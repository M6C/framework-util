package framework.ressource.util.cloud;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.URIResolver;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import framework.ressource.util.UtilFile;
import framework.ressource.util.UtilString;
import framework.ressource.xalan.xpath.domapi.XPathEvaluatorImpl;
import framework.ressource.xpath.XPathEvaluator;
import framework.ressource.xpath.XPathNSResolver;
import framework.ressource.xpath.XPathResult;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:
 * @author
 * @version 1.0
 */
public class UtilXML {
	public static final String PATH_SEPARATOR = "/";

    public UtilXML() {
    }

    public static Node appendChild(Document document, String name, String value) {
      Node ret = document.createElement(name);
      if (UtilString.isNotEmpty(value))
        ret.setNodeValue(value);
      document.appendChild(ret);
      return ret;
    }

    public static Node appendProcessingInstruction(Document document, String target, String data) {
      Node ret = document.createProcessingInstruction(target,data);
      document.appendChild(ret);
      return ret;
    }

    public static Node appendDocumentType(Document document, String name, String publicId, String systemId) {
      Node ret = document.getImplementation().createDocumentType(name, publicId, systemId);
      document.appendChild(ret);
      return ret;
    }

    public static Node appendChild(Node root, String name, String value) {
      Node ret = null;
      Document document = null;
      if(root instanceof Document)
        document = ((Document)root);
      else
        document = root.getOwnerDocument();
      ret = document.createElement(name);
      if (UtilString.isNotEmpty(value))
        ret.appendChild(document.createTextNode(value));
      root.appendChild(ret);
      return ret;
    }

    public static Node findChildByValue(Node root, String value) {
      return findChildByValue(root.getChildNodes(), value);
    }

    public static Node findChildByValue(NodeList nodeList, String value) {
      Node ret = null;
      if (nodeList!=null) {
        for (int i = 0; i < nodeList.getLength() && (ret == null); i++) {
          Node node = nodeList.item(i);
          ret = ( (node != null) && (value.equals(node.getNodeValue()))) ? node : null;
        }
      }
      return ret;
    }

	/**
	 * Ajout un element text à l'element passamp;eacute; en parametre
	 * Exemple Si path = elem1/elem2: Ajout de l'element elem2 après avoir ajout elem1 si il n'existe pas dans le document
	 * @param dom Document à modifier
	 * @param element Element à partir du quel on doit inserer les elements
	 * @param tagName Nom de l'element à ajouter
	 * @return Retourne le nouvel element cramp;eacute;er
	 */
	public static Element createElement(Document dom, Node root, String tagName){
		// Cramp;eacute;ation d'un nouvel element
		Element element = dom.createElement(tagName);
		// Ajout du noeud à l'amp;eacute;lamp;eacute;ment parent
		root.appendChild(element);
		// Retourne le nouvel element
		return element;
	}

	/**
	 * Ajout des amp;eacute;lamp;eacute;ments text au document à partir de la liste passamp;eacute; en paramètre.
	 * Avec insertion des elements intermediaires
	 * Exemple Si path = elem1/elem2: Ajout de l'element elem2 après avoir ajout elem1 si il n'existe pas dans le document
	 * @param dom Document à modifier
	 * @param list Liste des amp;eacute;lamp;eacute;ments à cramp;eacute;er (key: Chemin vers les amp;eacute;lamp;eacute;ments, value: valeur des amp;eacute;lamp;eacute;ments)
	 * @return Retourne null
	 */
	public static Element addElement(Document dom, Map list) throws UnsupportedEncodingException{
		return addElement(dom, list, null);
	}

	/**
	 * Ajout des amp;eacute;lamp;eacute;ments text au document à partir de la liste passamp;eacute; en paramètre.
	 * Avec insertion des elements intermediaires
	 * Exemple Si path = elem1/elem2: Ajout de l'element elem2 après avoir ajout elem1 si il n'existe pas dans le document
	 * @param dom Document à modifier
	 * @param list Liste des amp;eacute;lamp;eacute;ments à cramp;eacute;er (key: Chemin vers les amp;eacute;lamp;eacute;ments, value: valeur des amp;eacute;lamp;eacute;ments)
	 * @param encoding Type d'encodage de la valeur du dernier element
	 * @return Retourne null
	 */
	public static Element addElement(Document dom, Map list, String encoding) throws UnsupportedEncodingException{
		return addElement(dom, dom.getDocumentElement(), list);
	}

	/**
	 * Ajout des amp;eacute;lamp;eacute;ments text au document à partir de la liste passamp;eacute; en paramètre.
	 * Avec insertion des elements intermediaires
	 * Exemple Si path = elem1/elem2: Ajout de l'element elem2 après avoir ajout elem1 si il n'existe pas dans le document
	 * @param dom Document à modifier
	 * @param root Element à partir du quel on doit inserer les elements
	 * @param list Liste des amp;eacute;lamp;eacute;ments à cramp;eacute;er (key: Chemin vers les amp;eacute;lamp;eacute;ments, value: valeur des amp;eacute;lamp;eacute;ments)
	 * @return Retourne null
	 */
	public static Element addElement(Document dom, Element root, Map list) throws UnsupportedEncodingException{
		return addElement(dom, root, list, null);
	}

	/**
	 * Ajout des amp;eacute;lamp;eacute;ments text au document à partir de la liste passamp;eacute; en paramètre.
	 * Avec insertion des elements intermediaires
	 * Exemple Si path = elem1/elem2: Ajout de l'element elem2 après avoir ajout elem1 si il n'existe pas dans le document
	 * @param dom Document à modifier
	 * @param root Element à partir du quel on doit inserer les elements
	 * @param list Liste des amp;eacute;lamp;eacute;ments à cramp;eacute;er (key: Chemin vers les amp;eacute;lamp;eacute;ments, value: valeur des amp;eacute;lamp;eacute;ments)
	 * @param encoding Type d'encodage de la valeur du dernier element
	 * @return Retourne null
	 */
	public static Element addElement(Document dom, Element root, Map list, String encoding) throws UnsupportedEncodingException{
		Iterator listKey = list.keySet().iterator();
		String path = null, value = null;
		while(listKey.hasNext()){
			path = (String)listKey.next();
			value = (String)list.get(path);
			addElement(dom, root, path, value, encoding);
		}
		return null;
	}

	/**
	 * Ajout un element text au document. Avec insertion des elements intermediaires
	 * Exemple Si path = elem1/elem2: Ajout de l'element elem2 après avoir ajout elem1 si il n'existe pas dans le document
	 * @param dom Document à modifier
	 * @param path Chemin de l'amp;eacute;lement à ajout
	 * @return Retourne le nouvel element cramp;eacute;er
	 */
	public static Element addElement(Document dom, String path) throws UnsupportedEncodingException{
		return addElement(dom, path, null, null);
	}

	/**
	 * Ajout un element text au document. Avec insertion des elements intermediaires
	 * Exemple Si path = elem1/elem2: Ajout de l'element elem2 après avoir ajout elem1 si il n'existe pas dans le document
	 * @param dom Document à modifier
	 * @param path Chemin de l'amp;eacute;lement à ajout
	 * @param value Contenu de l'element text
	 * @param encoding Type d'encodage de la valeur du dernier element
	 * @return Retourne le nouvel element cramp;eacute;er
	 */
	public static Element addElement(Document dom, String path, String value, String encoding) throws UnsupportedEncodingException{
		return addElement(dom, dom.getDocumentElement(), path, value, encoding);
	}

	/**
	 * Ajout un element text au document. Avec insertion des elements intermediaires
	 * Exemple Si path = elem1/elem2: Ajout de l'element elem2 après avoir ajout elem1 si il n'existe pas dans le document
	 * @param dom Document à modifier
	 * @param root Element à partir du quel on doit inserer les elements
	 * @param path Chemin de l'amp;eacute;lement à ajout
	 * @return Retourne le nouvel element cramp;eacute;er
	 */
	public static Element addElement(Document dom, Element root, String path) throws UnsupportedEncodingException{
		return addElement(dom, root, path, null, null);
	}

	/**
	 * Ajout un element text au document. Avec insertion des elements intermediaires
	 * Exemple:<br>
	 *    Si path = /elem1/elem2: Ajout de l'element elem2 après avoir ajout elem1 si il n'existe pas dans le document<br>
	 *    Si path = /elem1/elem2/elem3 et que le chemin /elem1/elem2 existe damp;eacute;ja dans le document à partir de l'element root:<br>
	 *              Ajout de l'element elem3 après elem2 sans ajouter les elements elem1 et elem2<br>
	 *    Si path = /elem1/elem2/elem3 et que le chemin /elem1/elem2/elem3 existe damp;eacute;ja dans le document à partir de l'element root:<br>
	 *              Ajout d'un nouvel element elem3 après elem2 sans ajouter les elements elem1 et elem2<br>
	 * @param dom Document à modifier
	 * @param root Element à partir du quel on doit inserer les elements
	 * @param path Chemin de l'amp;eacute;lement à ajout
	 * @param value Contenu de l'element text
	 * @param encoding Type d'encodage de la valeur du dernier element
	 * @return Retourne le nouvel element cramp;eacute;er
	 */
	public static Element addElement(Document dom, Element root, String path, String value, String encoding) throws UnsupportedEncodingException{
		String tagName = null;
		NodeList nodeList = null;
		Element element = root;
		// Decoupe le chemin
		StringTokenizer token = new StringTokenizer(path, PATH_SEPARATOR);
		while(token.hasMoreElements()){
			tagName = token.nextToken();
			if (element==null) {
				// Cramp;eacute;ation d'un element ROOT
				element = createElement(dom, dom, tagName);
			}
			else {
				if (element.getNodeName().equals(tagName)){
					nodeList = element.getChildNodes();
					if ((!token.hasMoreElements())&&(element.getParentNode()!=null)){
						// Cramp;eacute;ation d'un nouvel element
						element = createElement(dom, element.getParentNode(), tagName);
					}
					else if ((nodeList!=null)&&(nodeList.getLength()>0))
						// Recupere le premier element de la liste
						element = (Element)nodeList.item(0);
				}
				else{
					nodeList = element.getElementsByTagName(tagName);
					if ((nodeList==null)||(nodeList.getLength()==0))
						// Cramp;eacute;ation d'un nouvel element
						element = createElement(dom, element, tagName);
					else{
						if ((!token.hasMoreElements())&&(element.getParentNode()!=null)){
							// Cramp;eacute;ation d'un nouvel element
							element = createElement(dom, element.getParentNode(), tagName);
						}
						else {
							// Recupere le premier element de la liste
							element = (Element)nodeList.item(0);
						}
					}
				}
			}
		}
		// Verifi si on a pu creer un nouvel element
		if((value!=null)&&(element!=null)&&(element!=root)){
			if ((encoding!=null)&&(!encoding.equals("")))
				// Encode la valeur si besoin
				value = URLEncoder.encode(value, encoding);
			// Initialise le text de l'element
			element.appendChild(dom.createTextNode(value));
		}
//		else if (root!=null)
//			element = null;
		// Retourne le nouvel element
		return element;
	}

    public static void writeXMLDocument(Node node, String fileName, int limiteNbCar) {
        if (UtilString.isNotEmpty(fileName)) {
            try {
                FileWriter fileWriter = new FileWriter(fileName);
                Writer output = new BufferedWriter(fileWriter);
                writeXMLNode(output, node, "", limiteNbCar);
                output.flush();
                output.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Recurse through all of the XML nodes and output them.
     */
    public static void writeXMLNode(Writer output, Node node, String indent, int limiteNbCar) {
        String indentLevel = "\t";
        int lineBreakWidth = 100;
        int lineLength = 0;
        boolean nodeChildFound = false;
        NodeList nodes;
//        int iLimiteNbCar = Integer.parseInt(Constante.getParameter(Constante.CST_FILE_INITIALISE_ELEMENT_PARAMETER_FRAMEWORK_UTILXML_LIMITE_TEXT_NB_CAR));

        try {
            switch (node.getNodeType()) {
              case Node.DOCUMENT_NODE:
              {
                nodes = node.getChildNodes(); // recurse on children
                if (nodes != null) {
                  // Ecrit les noeuds d'instances ProcessingInstruction
                  for (int i = 0; i < nodes.getLength(); i++)
                    if ( nodes.item(i) instanceof ProcessingInstruction )
                      writeXMLNode(output, nodes.item(i), "", limiteNbCar);
                  // Ecrit les noeuds d'instances DocumentType
                  for (int i = 0; i < nodes.getLength(); i++)
                    if ( nodes.item(i) instanceof DocumentType )
                      writeXMLNode(output, nodes.item(i), "", limiteNbCar);
                  // Ecrit les autres noeuds que les instances DocumentType
                  for (int i = 0; i < nodes.getLength(); i++)
                    if ( !((nodes.item(i) instanceof ProcessingInstruction)||(nodes.item(i) instanceof DocumentType)) )
                      writeXMLNode(output, nodes.item(i), "", limiteNbCar);
                }
              }
              break;

              case Node.DOCUMENT_TYPE_NODE:
                DocumentType documentType = (DocumentType) node;
                output.write("<!DOCTYPE " + documentType.getName());

                // first set X3D DOCTYPE to specified values
                if (documentType.getName().compareTo("X3D") == 0) {
                    output.write(" PUBLIC \"http://www.web3D.org/TaskGroups/x3d/translation/x3d-compact.dtd\" ");
                    output.write("                 \"file:///C:/www.web3D.org/TaskGroups/x3d/translation/x3d-compact.dtd");
                } else if ((documentType.getPublicId() != null) && (documentType.getSystemId() != null)) {
                    output.write(" PUBLIC \"" + documentType.getPublicId() + "\" \"" + documentType.getSystemId());
                } else if ((documentType.getPublicId() == null) && (documentType.getSystemId() != null)) {
                    output.write(" SYSTEM \"" + documentType.getSystemId());
                }

                nodes = node.getChildNodes(); // recurse on children, e.g. CDATA and namespaces
                if (nodes != null) {
                    for (int i = 0; i < nodes.getLength(); i++)
                        writeXMLNode(output, nodes.item(i), "", limiteNbCar);
                }

                if ((documentType.getPublicId() != null) && (documentType.getSystemId() != null)) {
                    output.write("\">" + "\n");
                } else if ((documentType.getPublicId() == null) && (documentType.getSystemId() != null)) {
                    output.write("\">" + "\n");
                } else {
                    output.write(">" + "\n");
                }
                break;

              case Node.ELEMENT_NODE:
                String name = node.getNodeName();
                output.write(indent + "<" + name);
                lineLength = name.length() + 2;

                NamedNodeMap attributes = node.getAttributes(); // print attributes first

                for (int i = 0; i < attributes.getLength(); i++) {
                    Node current = attributes.item(i);

                    if (UtilString.isEmpty(current.getNodeValue())) {
                        continue; // skip empty attributes
                    }

                    lineLength = lineLength + current.getNodeName().length() +
                        current.getNodeValue().length() + 4;

                    if (lineLength > lineBreakWidth) {
                        output.write("\n");
                        output.write(indent + "  ");
                        lineLength = current.getNodeName().length() +
                            indent.length() + current.getNodeValue().length() +
                            2;
                    }

                    // need to convert special-character content to character entities!!
                    output.write(" " + current.getNodeName() + "=\"" + current.getNodeValue() + "\"");
                }

                // determine if any actual element child nodes are present
                NodeList children = node.getChildNodes();

                for (int i = 0; i < children.getLength(); i++) {
                    nodeChildFound = true;
                    break;
                }

                // recurse on each non-attribute child
                if (nodeChildFound == true) {
                  output.write(">");
                  if (((children.getLength() == 1) &&
                       (children.item(0).getNodeType() == Node.TEXT_NODE) &&
                       ((limiteNbCar>0)&&(children.item(0).getNodeValue().trim().length() > limiteNbCar))) ||
                       (children.getLength() > 1))
                    output.write("\n");

                    //	output.write ("<!-- iterating over children -->\,");
                  for (int i = 0; i < children.getLength(); i++)
                    writeXMLNode(output, children.item(i), indent + indentLevel, limiteNbCar);

                  if (((children.getLength() == 1) &&
                        (children.item(0).getNodeType() == Node.TEXT_NODE) &&
                        ((limiteNbCar>0)&&(children.item(0).getNodeValue().trim().length() > limiteNbCar))) ||
                       (children.getLength() > 1))
                    output.write(indent + "</" + name + ">\n");
                  else
                    output.write("</" + name + ">\n");
                }
                else {
                  output.write("/>\n");
                }
                break;

              case Node.CDATA_SECTION_NODE:
                //	output.write (indent + "<!--CDATA_SECTION_NODE--> ");
                output.write(indent + "<![CDATA[" + node.getNodeValue() + "]]>\n");

                break;

              case Node.COMMENT_NODE:
                // normalize whitespace in comments since Xeena mangles it badly
                StringBuffer normalizedLine = new StringBuffer(node.getNodeValue().replace('\n', ' '));

                for (int i = 0; i < (normalizedLine.length() - 1); i++) {
                    if ((normalizedLine.charAt(i) == ' ') &&
                            (normalizedLine.charAt(i + 1) == ' ')) {
                        normalizedLine.deleteCharAt(i);
                        i--;
                    }
                }

                output.write(indent + "<!--" + normalizedLine + "-->\n");

                break;

              case Node.TEXT_NODE:
                //	trim() removes leading and trailing whitespace
                String szNodeValue = node.getNodeValue().trim();
                if ((limiteNbCar>0)&&(szNodeValue.length() > limiteNbCar))
                  //	output.write ("<!--non-zero TEXT_NODE--> ");
                  output.write(indent + szNodeValue + "\n");
                else if (szNodeValue.length() > 0)
                  //	output.write ("<!--non-zero TEXT_NODE--> ");
                  output.write(szNodeValue);
                break;

              case Node.PROCESSING_INSTRUCTION_NODE:
                output.write(indent + "<?" + node.getNodeName() + " " + node.getNodeValue() + "?>" + "\n");
                break;

              case Node.ENTITY_REFERENCE_NODE:
                output.write("&" + node.getNodeName() + ";");
                break;
            }
        } catch (Exception badPrint) {
            System.err.println("Error in writeNode: " + badPrint.getMessage() + "\n");
            badPrint.printStackTrace();
        }
    }

	/**
	 * Retourne la valeur du dernier element à partir d'un chemin au format XPath
	 * Exemple: si path='/elm1/elm2' :
	 *               La methode retourne le contenu de l'element 'elm2' après 'elm1'
	 * @param dom Document à modifier
	 * @param path Chemin de l'amp;eacute;lement à ajout
	 * @return Retourne la valeur du dernier element du chemin
	 */
	public static String getElementValue(Document dom, String path) throws UnsupportedEncodingException{
		return getElementValue(dom.getDocumentElement(), path);
	}

	/**
	 * Retourne la valeur du dernier element à partir d'un chemin au format XPath
	 * Exemple: si path='/elm1/elm2' :
	 *               La methode retourne le contenu de l'element 'elm2' après 'elm1'
	 * @param root Element de depart de la recherche
	 * @param path Chemin de l'amp;eacute;lement à rechercher
	 * @return Retourne la valeur du dernier element du chemin
	 */
	public static String getElementValue(Element root, String path) throws UnsupportedEncodingException{
		String ret = null;
		Element element = getElement(root, path);
		if (element!=null)
			ret = getNodeValue(element);
		return ret;
	}

	/**
	 * Retourne la valeur d'un attribut du dernier element à partir d'un chemin au format XPath
	 * Exemple: si path='/elm1/elm2' :
	 *               La methode retourne le contenu de l'element 'elm2' après 'elm1'
	 * @param root Element de depart de la recherche
	 * @param path Chemin de l'amp;eacute;lement à rechercher
	 * @return Retourne la valeur d'un attribut du dernier element du chemin
	 */
	public static String getElementAttributValue(Element root, String path, String attribut) throws UnsupportedEncodingException{
		String ret = null;
		Element element = getElement(root, path);
		if (element!=null)
			ret = element.getAttribute(attribut);
		return ret;
	}

	/**
	 * Retourne le dernier element à partir d'un chemin au format XPath
	 * Exemple: si path='/elm1/elm2' :
	 *               La methode retourne l'element 'elm2' après 'elm1'
	 * @param dom Document à parcourir
	 * @param path Chemin de l'amp;eacute;lement à rechercher
	 * @return Retourne le dernier element du chemin
	 */
	public static Element getElement(Document dom, String path) throws UnsupportedEncodingException{
		return getElement(dom.getDocumentElement(), path);
	}

	/**
	 * Retourne le dernier element à partir d'un chemin au format XPath
	 * Exemple: si path='/elm1/elm2' :
	 *               La methode retourne l'element 'elm2' après 'elm1'
	 * @param root Element de depart de la recherche
	 * @param path Chemin de l'amp;eacute;lement à rechercher
	 * @return Retourne le dernier element du chemin
	 */
	public static Element getElement(Element root, String path) throws UnsupportedEncodingException{
		Element ret = root;
		if ((root!=null)&&(path!=null)){
			String tagName = null;
			NodeList nodeList = null;
			// Decoupe le chemin
			StringTokenizer token = new StringTokenizer(path, PATH_SEPARATOR);
			while(token.hasMoreElements()){
				tagName = token.nextToken();
				if (!tagName.equals(root.getNodeName())) {
					nodeList = ret.getElementsByTagName(tagName);
					if ((nodeList==null)||(nodeList.getLength()==0))
						// arret de la recherche
						break;
					else{
						// Recupere le dernier element de la liste
						ret = (Element)nodeList.item(nodeList.getLength()-1);
					}
				}
			}
		}
		// Retourne l'element
		return ret;
	}

	/**
	 * Retourne la liste des valeurs du dernier element à partir d'un chemin au format XPath
	 * Exemple: si path='/elm1/elm2' :
	 *               La methode recherche la liste des 'elm2' après 'elm1'
	 *               et retourne un tableau de chaine representant le
	 *               contenu de chaque element 'elm2'
	 * @param root Element de depart de la recherche
	 * @param path Chemin de l'amp;eacute;lement à rechercher
	 * @return Retourne la liste des valeur du dernier element du chemin
	 */
	public static String[] getListElementValue(Element root, String path) throws UnsupportedEncodingException{
		String[] ret = null;
		NodeList nodeList =  getNodeList(root, path);
		// Verifi si la recherche est allamp;eacute;e jusqu'à la fin
		if (nodeList!=null) {
			int size = nodeList.getLength();
			// Verifi si la liste des elements est renseignamp;eacute;e
			if (size>0) {
				ret = new String[size];
				// Recupere toutes les valeurs des elements de la liste
				for(int i=0 ; i<size ; i++){
					ret[i] = getNodeValue(nodeList.item(i));
				}
			}
		}
		// Retourne l'element
		return ret;
	}

	/**
	 * Retourne la liste des valeurs d'un attribut du dernier element à partir d'un chemin au format XPath<br>
	 * Exemple: si path='/elm1/elm2' et que attribut='code' :
	 *               La methode recherche la liste des 'elm2' après 'elm1'
	 *               et retourne une liste de chaine representant la valeur
	 *               de l'attribut 'code' pour chaque element 'elm2'
	 * @param root Element de depart de la recherche
	 * @param path Chemin de l'amp;eacute;lement à rechercher
	 * @return Retourne la liste des valeur du dernier element du chemin
	 */
	public static String[] getListElementAttributValue(Element root, String path, String attribut) throws UnsupportedEncodingException{
		String[] ret = null;
		NodeList nodeList =  getNodeList(root, path);
		// Verifi si la recherche est allamp;eacute;e jusqu'à la fin
		if (nodeList!=null) {
			int size = nodeList.getLength();
			// Verifi si la liste des elements est renseignamp;eacute;e
			if (size>0) {
				ret = new String[size];
				// Recupere la valeur de l'attribut des elements de la liste
				for(int i=0 ; i<size ; i++){
					ret[i] = ((Element)nodeList.item(i)).getAttribute(attribut);
				}
			}
		}
		// Retourne l'element
		return ret;
	}

	/**
	 * Converti un document Xmli en String
	 * @param dom Document xml à convertir
	 * @param encoding Encodage
	 * @param version Version du document xml
	 * @return Une chaine de caractère qui represente le document
	 * @throws IOException En cas d'erreur de serialisation du document
	 */
/*
	public static String documentToString(Document dom, String encoding, String version) throws IOException {
		String ret = "";
		// Formatage du document XML avec les outils Xerces
		StringWriter writer = new StringWriter();
		// Cramp;eacute;ation d'un objet de format de sortie avec le type d'encodage
		OutputFormat outputFormat = new OutputFormat("xml", encoding, true);
		// Initialisation du numero de version
		outputFormat.setVersion(version);
		// Objet de serialisation du document
		XMLSerializer ser = new XMLSerializer(writer, outputFormat);
		// Serialisation du document dans une chaine de caractamp;eacute;res
		ser.serialize(dom);
		// Envoi du document dans coda
		ret = writer.toString();
		return ret;
	}
*/
	/**
	 * Retourne la liste des noeuds à partir d'un chemin au format XPath<br>
	 * Exemple: si path='/elm1/elm2' et que attribut='code' :
	 *               La methode recherche la liste des 'elm2' après 'elm1'
	 *               et retourne une liste de chaine representant la valeur
	 *               de l'attribut 'code' pour chaque element 'elm2'
	 * @param root Element de depart de la recherche
	 * @param path Chemin de l'amp;eacute;lement à rechercher
	 * @return Retourne la liste des noeuds du dernier element du chemin. null si le dernier noeud n'a pas amp;eacute;tamp;eacute; trouvamp;eacute;.
	 */
	public static NodeList getNodeList(Element root, String path) throws UnsupportedEncodingException{
		NodeList ret = null;
		if ((root!=null)&&(path!=null)){
			Element element = root;
			NodeList nodeList = null;
			boolean end = true;
			// Decoupe le chemin
			StringTokenizer token = new StringTokenizer(path, PATH_SEPARATOR);
			while(token.hasMoreElements()){
				nodeList = element.getElementsByTagName(token.nextToken());
				if ((nodeList==null)||(nodeList.getLength()==0)) {
					end = false;
					// arret de la recherche
					break;
				}
				else
					// Recupere le premier element de la liste
					element = (Element)nodeList.item(0);
			}
			// Verifi si la recherche est allamp;eacute;e jusqu'à la fin
			if (end)
				ret = nodeList;
		}
		// Retourne l'element
		return ret;
	}

	/**
	 * Retourne le contenu de type text d'un noeud
	 * @param node Noeud dans lequel on recupere le text
	 * @return Le contenu text du noeud
	 */
	public static String getNodeValue(Node node) {
		String ret = null;
		try {ret=getNodeValue(node, null);}
		catch(UnsupportedEncodingException ex){}
		return ret;
	}

	/**
	 * Retourne le contenu de type text d'un noeud
	 * @param node Noeud dans lequel on recupere le text
	 * @return Le contenu text du noeud
	 */
	public static String getNodeValue(Node node, String encoding) throws UnsupportedEncodingException{
		String ret = "";
		NodeList nodeList = node.getChildNodes();
		if (nodeList!=null) {
			Node item = null;
			int size = nodeList.getLength();
			for (int i = 0; i < size; i++) {
				item = nodeList.item(i);
				if(item.getNodeType()==Node.TEXT_NODE) {
					ret += item.getNodeValue();
				}
			}
			if (encoding!=null)
			ret = URLDecoder.decode(ret, encoding);
		}
		return ret;
	}

	/**
	 * Ajoute un element texte au noeud passamp;eacute; en paramètre
	 * @param dom Document source
	 * @param node Noeud à modifier
	 * @param value Texte à ajouter au noeud
	 */
	public static void setNodeValue(Document dom, Node node, String value) {
		try{setNodeValue(dom, node, value, null);}
		catch(UnsupportedEncodingException ex){}
	}

	/**
	 * Ajoute un element texte au noeud passamp;eacute; en paramètre
	 * @param dom Document source
	 * @param node Noeud à modifier
	 * @param value Texte à ajouter au noeud
	 * @param encoding Encodage à appliquer au texte (peut être null)
	 * @throws UnsupportedEncodingException En cas d'erreur d'encodage du texte
	 */
	public static void setNodeValue(Document dom, Node node, String value, String encoding) throws UnsupportedEncodingException{
		// Verifi si on a pu creer un nouvel element
		if ((value!=null)&&(node!=null)) {
			if ((encoding!=null)&&(!encoding.equals("")))
				// Encode la valeur si besoin
				value = URLEncoder.encode(value, encoding);
			// Initialise le text de l'element
			node.appendChild(dom.createTextNode(value));
		}
	}

	/**
	 * Supprime tous les enfants du noeud passamp;eacute; en paramètre
	 * @param node Noeud à modifier
	 */
	public static void removeAllChildNode(Node node){
		if (node!=null){
			NodeList nodeList = node.getChildNodes();
			if (nodeList!=null){
				int size = nodeList.getLength();
				for(int i=0 ; i<size ; node.removeChild(nodeList.item(i++)));
			}
		}
	}

        public static Document createDocument(String fileName) throws IOException, SAXException, ParserConfigurationException {
          DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
          DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
          return docBuilder.parse(fileName);
        }

	public static String getXPathStringValue(Document doc, String xPath){
		return getXPathStringValue(doc, doc, xPath);
	}

	public static String getXPathStringValue(Document doc, Node contextNode, String xPath){
//	  XPathEvaluator evaluator = new XPathEvaluatorImpl(doc);
//	  return getXPathStringValue(evaluator, doc, contextNode, xPath);
	  return getXPathStringValue(null, doc, contextNode, xPath);
	}

	public static String getXPathStringValue(XPathEvaluator evaluator, Document doc, String xPath) {
		return getXPathStringValue(evaluator, doc, doc, xPath);
	}
/*
	public static String getXPathStringValue(XPathEvaluator evaluator, Document doc, Node contextNode, String xPath) {
		  String ret = null;
		  if ((evaluator!=null)&&(doc!=null)&&(UtilString.isNotEmpty(xPath))) {
			XPathNSResolver resolver = evaluator.createNSResolver(doc);
			if (resolver!=null) {
			  XPathResult c = (XPathResult) evaluator.evaluate(xPath, contextNode, resolver, XPathResult.STRING_TYPE, null);
			  if (c != null)
				ret = c.getStringValue();
			}
		  }
		  return ret;
		}
*/
	public static String getXPathStringValue(XPathEvaluator evaluator, Document doc, Node contextNode, String xPath) {
		String ret = null;
		try {
			String szXsl = "<xsl:stylesheet version='1.0' xmlns:xsl='http://www.w3.org/1999/XSL/Transform'>"
				+ "<xsl:output method='text' encoding='ISO-8859-1' indent='no'/>"
				+ "<xsl:template match='/'>"
				+ "<xsl:value-of select='"+xPath+"'/>"
				+ "</xsl:template>"
				+ "</xsl:stylesheet>";
	
			StringReader xslReader = new StringReader(szXsl);
			
			TransformerFactory tFactory = TransformerFactory.newInstance(
				"org.apache.xalan.processor.TransformerFactoryImpl",
				Thread.currentThread().getContextClassLoader()); 
			Source xmlSource = new DOMSource(doc);
			Source xslSource = new StreamSource(xslReader);
			// Generate the transformer.
			Transformer transformer = tFactory.newTransformer(xslSource);
			StringWriter strWriter = new StringWriter();
			// Perform the transformation, sending the output to the response.
			transformer.transform(xmlSource, new StreamResult(strWriter));
			// Get the Xml result
			ret = strWriter.toString();
		}
		// If an Exception occurs, write the error to the page.
		catch (Exception ex) {
			StringWriter s = new StringWriter();
			ex.printStackTrace(new PrintWriter(s));
			System.err.println("ERROR getXPathStringValue Exception ex:"+s.toString());
		}
		return ret;
	}
	
	public static Node getXPathNode(Document doc, String xPath) {
		XPathEvaluator evaluator = new XPathEvaluatorImpl(doc);
		return getXPathNode(evaluator, doc, doc, xPath);
	}

	public static Node getXPathNode(Document doc, Node contextNode, String xPath) {
		XPathEvaluator evaluator = new XPathEvaluatorImpl(doc);
		return getXPathNode(evaluator, doc, contextNode, xPath);
	}

	public static Node getXPathNode(XPathEvaluator evaluator, Document doc, String xPath) {
		return getXPathNode(evaluator, doc, doc, xPath);
	}

	public static Node getXPathNode(XPathEvaluator evaluator, Document doc, Node contextNode, String xPath) {
	  Node ret = null;
	  if ((evaluator!=null)&&(doc!=null)&&(UtilString.isNotEmpty(xPath))) {
		XPathNSResolver resolver = evaluator.createNSResolver(doc);
		if (resolver!=null) {
		  XPathResult c = (XPathResult) evaluator.evaluate(xPath, contextNode, resolver, XPathResult.ANY_UNORDERED_NODE_TYPE, null);
		  if (c != null)
			ret = c.getSingleNodeValue();
		}
	  }
	  return ret;
	}

	public static XPathResult getXPathResultNodeUnordered(Document doc, String xPath) {
		XPathEvaluator evaluator = new XPathEvaluatorImpl(doc);
		return getXPathResultNodeUnordered(evaluator, doc, doc, xPath);
	}

	public static XPathResult getXPathResultNodeUnordered(Document doc, Node contextNode, String xPath) {
		XPathEvaluator evaluator = new XPathEvaluatorImpl(doc);
		return getXPathResultNodeUnordered(evaluator, doc, contextNode, xPath);
	}

	public static XPathResult getXPathResultNodeUnordered(XPathEvaluator evaluator, Document doc, String xPath) {
		return getXPathResultNodeUnordered(evaluator, doc, doc, xPath);
	}

	public static XPathResult getXPathResultNodeUnordered(XPathEvaluator evaluator, Document doc, Node contextNode, String xPath) {
		return getXPathResultNode(XPathResult.UNORDERED_NODE_ITERATOR_TYPE, evaluator, doc, contextNode, xPath);
	}

	public static XPathResult getXPathResultNodeOrdered(Document doc, String xPath) {
		XPathEvaluator evaluator = new XPathEvaluatorImpl(doc);
		return getXPathResultNodeOrdered(evaluator, doc, doc, xPath);
	}

	public static XPathResult getXPathResultNodeOrdered(Document doc, Node contextNode, String xPath) {
		XPathEvaluator evaluator = new XPathEvaluatorImpl(doc);
		return getXPathResultNodeOrdered(evaluator, doc, contextNode, xPath);
	}

	public static XPathResult getXPathResultNodeOrdered(XPathEvaluator evaluator, Document doc, String xPath) {
		return getXPathResultNodeOrdered(evaluator, doc, doc, xPath);
	}

	public static XPathResult getXPathResultNodeOrdered(XPathEvaluator evaluator, Document doc, Node contextNode, String xPath) {
		return getXPathResultNode(XPathResult.ORDERED_NODE_ITERATOR_TYPE, evaluator, doc, contextNode, xPath);
	}
/*
	public static XPathResult getXPathResultNode(short type, XPathEvaluator evaluator, Document doc, Node contextNode, String xPath) {
		try {
/**-/
			String szXsl = "<xsl:stylesheet version='1.0' xmlns:xsl='http://www.w3.org/1999/XSL/Transform'>"
				+ "<xsl:output method='xml' encoding='ISO-8859-1' indent='yes'/>"

				+ "<!-- Copie toutes les balises -->"
				+ "<xsl:template match='"+xPath+"'>"
				+ "<xsl:element name='{name()}'>"
//				+ "<xsl:apply-templates select='@*'/>"
/*
				+ "<xsl:template match='@*'>"
				+ "<xsl:attribute name='{name()}'>"
				+ "<xsl:value-of select='.'/>"
				+ "</xsl:attribute>"
				+ "</xsl:template>"
*-/
//				+ "<xsl:apply-templates/>"
				+ "</xsl:element>"
				+ "</xsl:template>"

				+ "<!-- Copie tous les attributs -->"
				+ "<xsl:template match='"+xPath+"/@*'>"
				+ "<xsl:attribute name='{name()}'>"
				+ "<xsl:value-of select='.'/>"
				+ "</xsl:attribute>"
				+ "</xsl:template>"
				+ "</xsl:stylesheet>";
/**/
/*
			String szXsl = "<xsl:stylesheet version='1.0' xmlns:xsl='http://www.w3.org/1999/XSL/Transform'>"
				+ "<xsl:output method='xml' encoding='ISO-8859-1' indent='yes'/>"
				+ "<!-- Ajout de l'element ROOT -->"
				+ "<xsl:element name='ROOT'>"
				+ "<!-- Applique les templates que sur les sous elements de ROOT -->"
				+ "<xsl:template match='"+xPath+"'>"

				+ "<xsl:element name='{name()}'>"

				+ "<xsl:apply-templates select='@*'/>"
				+ "<xsl:apply-templates/>"

				+ "</xsl:element>"
				+ "</xsl:template>"
				+ "</xsl:element>"
				+ "</xsl:stylesheet>";
*/
/*
				String szXsl = "<xsl:stylesheet version='1.0' xmlns:xsl='http://www.w3.org/1999/XSL/Transform'>"
					+ "<xsl:output method='xml' encoding='ISO-8859-1' indent='yes'/>"

					+ "<!-- Copie toutes les balises -->"
					+ "<xsl:template match='"+xPath+"'>"
					+ "<xsl:element name='{name()}'>"
//					+ "<xsl:apply-templates select='@*'/>"

					+ "<xsl:for-each select="@*">
					<!-- Creer un attribut avec le nom de l'attribut courant -->
					<xsl:attribute name="{name()}">
			      <xsl:value-of select="."/>
					</xsl:attribute>
		    </xsl:for-each>
					+ "<xsl:template match='@*'>"
					+ "<xsl:attribute name='{name()}'>"
					+ "<xsl:value-of select='.'/>"
					+ "</xsl:attribute>"
					+ "</xsl:template>"

//					+ "<xsl:apply-templates/>"
					+ "</xsl:element>"
					+ "</xsl:template>"

					+ "<!-- Copie tous les attributs -->"
					+ "<xsl:template match='"+xPath+"/@*'>"
					+ "<xsl:attribute name='{name()}'>"
					+ "<xsl:value-of select='.'/>"
					+ "</xsl:attribute>"
					+ "</xsl:template>"
					+ "</xsl:stylesheet>";
*-/
			StringReader xslReader = new StringReader(szXsl);

			TransformerFactory tFactory = TransformerFactory.newInstance(
				"org.apache.xalan.processor.TransformerFactoryImpl",
				Thread.currentThread().getContextClassLoader()); 
			Source xmlSource = new DOMSource(doc);
			Source xslSource = new StreamSource(xslReader);
			// Generate the transformer.
			Transformer transformer = tFactory.newTransformer(xslSource);

			StringWriter strWriter = new StringWriter();
			// Perform the transformation, sending the output to the response.
			transformer.transform(xmlSource, new StreamResult(strWriter));

			DOMResult domResult = new DOMResult();
			// Perform the transformation, sending the output to the response.
			transformer.transform(xmlSource, domResult);
			// Get the Xml result
			return null;
		}
		// If an Exception occurs, write the error to the page.
		catch (Exception ex) {
			StringWriter s = new StringWriter();
			ex.printStackTrace(new PrintWriter(s));
			System.err.println("ERROR getXPathStringValue Exception ex:"+s.toString());
		}
		return null;
	}
*/

	public static XPathResult getXPathResultNode(short type, XPathEvaluator evaluator, Document doc, Node contextNode, String xPath) {
		XPathResult ret = null;
	  if ((evaluator!=null)&&(doc!=null)&&(UtilString.isNotEmpty(xPath))) {
		XPathNSResolver resolver = evaluator.createNSResolver(doc);
		if (resolver!=null) {
		  ret = (XPathResult) evaluator.evaluate(xPath, contextNode, resolver, XPathResult.ORDERED_NODE_ITERATOR_TYPE, null);
		}
	  }
	  return ret;
	}

	public static void tranformeXmlWithXsl(File fileXml, File fileXsl, Writer writer) throws TransformerException {
		tranformeXmlWithXsl(fileXml, fileXsl, writer, null);
	}
	public static void tranformeXmlWithXsl(File fileXml, File fileXsl, Writer writer, Dictionary parameters) throws TransformerException {
		tranformeXmlWithXsl(new StreamSource(fileXml), new StreamSource(fileXsl), writer, parameters);
	}
	public static void tranformeXmlWithXsl(Document domXml, File fileXsl, Writer writer) throws TransformerException {
		tranformeXmlWithXsl(domXml, fileXsl, writer, null);
	}
	public static void tranformeXmlWithXsl(Document domXml, File fileXsl, Writer writer, Dictionary parameters) throws TransformerException {
		tranformeXmlWithXsl(new DOMSource(domXml), new StreamSource(fileXsl), writer, parameters);
	}
	public static void tranformeXmlWithXsl(Document domXml, InputStream inputXsl, Writer writer) throws TransformerException {
		tranformeXmlWithXsl(domXml, inputXsl, writer, null);
	}
	public static void tranformeXmlWithXsl(Document domXml, InputStream inputXsl, Writer writer, Dictionary parameters) throws TransformerException {
		tranformeXmlWithXsl(domXml, inputXsl, writer, parameters, null);
	}
	public static void tranformeXmlWithXsl(Document domXml, InputStream inputXsl, Writer writer, Dictionary parameters, URIResolver uriResolver) throws TransformerException {
		tranformeXmlWithXsl(new DOMSource(domXml), new StreamSource(inputXsl), writer, parameters, uriResolver);
	}
	public static void tranformeXmlWithXsl(Source xmlSource, Source xslSource, Writer writer) throws TransformerException {
		tranformeXmlWithXsl(xmlSource, xslSource, writer, null);
	}
        public static void tranformeXmlWithXsl(Source xmlSource, Source xslSource, Writer writer, Dictionary parameters) throws TransformerException {
                tranformeXmlWithXsl(xmlSource, xslSource, writer, parameters, null);
        }
        public static void tranformeXmlWithXsl(Source xmlSource, Source xslSource, Writer writer, Dictionary parameters, URIResolver uriResolver) throws TransformerException {
			//TransformerFactory tFactory = TransformerFactory.newInstance();
			javax.xml.transform.TransformerFactory tFactory = TransformerFactory.newInstance(
				"org.apache.xalan.processor.TransformerFactoryImpl",
				Thread.currentThread().getContextClassLoader()); 
        StreamResult streamResult = new StreamResult(writer);
                // Generate the transformer.
        		tFactory.setURIResolver(uriResolver);
                Transformer transformer = tFactory.newTransformer(xslSource);
                transformer.setURIResolver(uriResolver);
                if (parameters!=null) {
                        Enumeration keys = parameters.keys();
                        Object key, val;
                        while(keys.hasMoreElements()) {
                                key = keys.nextElement();
                                val = parameters.get(key);
                                transformer.setParameter(key.toString(), val);
                        }
                }
        // Perform the transformation, sending the output to the response.
        transformer.transform(xmlSource, streamResult);
        }

        public static Document tranformeXmlWithXslToDom(Document domXml, InputStream inputXsl, Dictionary parameters) throws TransformerException, ParserConfigurationException, SAXException, IOException {
          return tranformeXmlWithXslToDom(domXml, inputXsl, parameters, null);
        }

        public static Document tranformeXmlWithXslToDom(Document domXml, InputStream inputXsl, Dictionary parameters, URIResolver uriResolver) throws TransformerException, ParserConfigurationException, SAXException, IOException {
          Document ret = null;

          StringWriter strWriter = new StringWriter();
          UtilXML.tranformeXmlWithXsl(new DOMSource(domXml), new StreamSource(inputXsl), strWriter, parameters, uriResolver);
          String strResult = strWriter.toString();

          if (UtilString.isEmpty(strResult))
            throw new IllegalArgumentException("The document is empty");
          else {
            StringReader strReader = new StringReader(strResult);
            // Creation des outils de Parse du fichier XML
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder;
            docBuilder = docBuilderFactory.newDocumentBuilder();
            // Build the dom document from the result
            ret = docBuilder.parse(new InputSource(strReader));
          }

          return ret;
        }
        
        public static void writeXml(File file, Document dom) throws TransformerException, FileNotFoundException, IOException {
			StringWriter strWriter = new StringWriter();
			//TransformerFactory tFactory = TransformerFactory.newInstance();
			javax.xml.transform.TransformerFactory tFactory = TransformerFactory.newInstance(
				"org.apache.xalan.processor.TransformerFactoryImpl",
				Thread.currentThread().getContextClassLoader()); 
	        Transformer transformer = tFactory.newTransformer();
	        transformer.transform(new DOMSource(dom), new StreamResult(strWriter));
	        UtilFile.write(file, strWriter.toString());
        }
}
