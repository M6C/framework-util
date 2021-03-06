// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SourceTreeManager.java

package framework.ressource.xalan.xpath;

import java.io.IOException;
import java.util.Vector;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamSource;
import org.apache.xml.dtm.DTM;
import org.apache.xml.dtm.DTMWSFilter;
import org.apache.xml.utils.SystemIDResolver;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

// Referenced classes of package framework.ressource.xalan.xpath:
//            SourceTree, XPathContext

public class SourceTreeManager
{

    public SourceTreeManager()
    {
        m_sourceTree = new Vector();
    }

    public void reset()
    {
        m_sourceTree = new Vector();
    }

    public void setURIResolver(URIResolver resolver)
    {
        m_uriResolver = resolver;
    }

    public URIResolver getURIResolver()
    {
        return m_uriResolver;
    }

    public String findURIFromDoc(int owner)
    {
        int n = m_sourceTree.size();
        for(int i = 0; i < n; i++)
        {
            SourceTree sTree = (SourceTree)m_sourceTree.elementAt(i);
            if(owner == sTree.m_root)
                return sTree.m_url;
        }

        return null;
    }

    public Source resolveURI(String base, String urlString, SourceLocator locator)
        throws TransformerException, IOException
    {
        Source source = null;
        if(null != m_uriResolver)
            source = m_uriResolver.resolve(urlString, base);
        if(null == source)
        {
            String uri = SystemIDResolver.getAbsoluteURI(urlString, base);
            source = new StreamSource(uri);
        }
        return source;
    }

    public void removeDocumentFromCache(int n)
    {
        if(-1 == n)
            return;
        for(int i = m_sourceTree.size() - 1; i >= 0; i--)
        {
            SourceTree st = (SourceTree)m_sourceTree.elementAt(i);
            if(st != null && st.m_root == n)
            {
                m_sourceTree.removeElementAt(i);
                return;
            }
        }

    }

    public void putDocumentInCache(int n, Source source)
    {
        int cachedNode = getNode(source);
        if(-1 != cachedNode)
            if(cachedNode != n)
                throw new RuntimeException("Programmer's Error!  putDocumentInCache found reparse of doc: " + source.getSystemId());
            else
                return;
        if(null != source.getSystemId())
            m_sourceTree.addElement(new SourceTree(n, source.getSystemId()));
    }

    public int getNode(Source source)
    {
        String url = source.getSystemId();
        if(null == url)
            return -1;
        int n = m_sourceTree.size();
        for(int i = 0; i < n; i++)
        {
            SourceTree sTree = (SourceTree)m_sourceTree.elementAt(i);
            if(url.equals(sTree.m_url))
                return sTree.m_root;
        }

        return -1;
    }

    public int getSourceTree(String base, String urlString, SourceLocator locator, XPathContext xctxt)
        throws TransformerException
    {
        try
        {
            Source source = resolveURI(base, urlString, locator);
            return getSourceTree(source, locator, xctxt);
        }
        catch(IOException ioe)
        {
            throw new TransformerException(ioe.getMessage(), locator, ioe);
        }
    }

    public int getSourceTree(Source source, SourceLocator locator, XPathContext xctxt)
        throws TransformerException
    {
        int n = getNode(source);
        if(-1 != n)
            return n;
        n = parseToNode(source, locator, xctxt);
        if(-1 != n)
            putDocumentInCache(n, source);
        return n;
    }

    public int parseToNode(Source source, SourceLocator locator, XPathContext xctxt)
        throws TransformerException
    {
        try
        {
            Object xowner = xctxt.getOwnerObject();
            DTM dtm;
            if(null != xowner && (xowner instanceof DTMWSFilter))
                dtm = xctxt.getDTM(source, false, (DTMWSFilter)xowner, false, true);
            else
                dtm = xctxt.getDTM(source, false, null, false, true);
            return dtm.getDocument();
        }
        catch(Exception e)
        {
            throw new TransformerException(e.getMessage(), locator, e);
        }
    }

    public static XMLReader getXMLReader(Source inputSource, SourceLocator locator)
        throws TransformerException
    {
        try
        {
            XMLReader reader = (inputSource instanceof SAXSource) ? ((SAXSource)inputSource).getXMLReader() : null;
            if(null == reader)
            {
                try
                {
                    SAXParserFactory factory = SAXParserFactory.newInstance();
                    factory.setNamespaceAware(true);
                    SAXParser jaxpParser = factory.newSAXParser();
                    reader = jaxpParser.getXMLReader();
                }
                catch(ParserConfigurationException ex)
                {
                    throw new SAXException(ex);
                }
                catch(FactoryConfigurationError ex1)
                {
                    throw new SAXException(ex1.toString());
                }
                catch(NoSuchMethodError ex2) { }
                catch(AbstractMethodError ame) { }
                if(null == reader)
                    reader = XMLReaderFactory.createXMLReader();
            }
            try
            {
                reader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
            }
            catch(SAXException se) { }
            return reader;
        }
        catch(SAXException se)
        {
            throw new TransformerException(se.getMessage(), locator, se);
        }
    }

    private Vector m_sourceTree;
    URIResolver m_uriResolver;
}
