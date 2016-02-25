package framework.ressource.xpath;

/*JDK 1.4
import org.apache.xml.utils.PrefixResolverDefault;
*/
//JDK 1.5
//import com.sun.org.apache.xml.internal.utils.PrefixResolverDefault;
import org.w3c.dom.Node;
/*
import org.w3c.dom.xpath.XPathNSResolver;
*/

/**
 * <meta name="usage" content="experimental"/>
 *
 * The class provides an implementation XPathNSResolver according 
 * to the DOM L3 XPath API Specification, Working Draft 28, March 2002.
 * 
 * 
 * <p>The <code>XPathNSResolver</code> interface permit <code>prefix</code> 
 * strings in the expression to be properly bound to 
 * <code>namespaceURI</code> strings. <code>XPathEvaluator</code> can 
 * construct an implementation of <code>XPathNSResolver</code> from a node, 
 * or the interface may be implemented by any application.</p>
 * <p>See also the <a href='http://www.w3.org/TR/2002/WD-DOM-Level-3-XPath-20020328'>Document Object Model (DOM) Level 3 XPath Specification</a>.</p>
 * 
 * @see org.w3c.dom.xpath.XPathNSResolver
 */
public class XPathNSResolverImpl extends PrefixResolverDefault implements XPathNSResolver {

    /**
     * Constructor for XPathNSResolverImpl.
     * @param xpathExpressionContext
     */
    public XPathNSResolverImpl(Node xpathExpressionContext) {
        super(xpathExpressionContext);
    }

    /**
     * @see org.w3c.dom.xpath.XPathNSResolver#lookupNamespaceURI(String)
     */
    public String lookupNamespaceURI(String prefix) {
        return super.getNamespaceForPrefix(prefix);
    }

}
