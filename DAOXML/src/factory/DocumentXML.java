/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;



import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import  org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author firas
 */
public class DocumentXML {

        static DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
       public static Document documentVoiture;
       public static String pathVoitureXMLFile;
       public static Document getVoitureDocument()
       {
           //DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
           DocumentBuilder builder;
           try {
               builder = factory.newDocumentBuilder();
               if (documentVoiture==null)
               {
                    documentVoiture = builder.newDocument();
                    Element racine = documentVoiture.createElement("Voitures");
                    documentVoiture.appendChild(racine);
               }
           } catch (ParserConfigurationException ex) {
        Logger       .getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
           }
             
           
           
           return documentVoiture;
       }
       public static Document getVoitureDocument(String path) 
       {
           
           DocumentBuilder builder;
           try {
               builder = factory.newDocumentBuilder();
               if (documentVoiture==null)
               {
                    documentVoiture = builder.parse(new File(path));
               }
           } catch (ParserConfigurationException | SAXException | IOException ex) {
                Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           
           return documentVoiture;
       }
       
        public static boolean saveVoitureDocument(String path) 
       {
          try 
           {
               factory.setNamespaceAware(true);
               TransformerFactory transformerFactory =TransformerFactory.newInstance();
               Transformer transformer = transformerFactory.newTransformer();
               DOMSource source = new DOMSource(documentVoiture);
                StreamResult sortie = new StreamResult(new File(path));
                transformer.transform(source, sortie);
                return true;
           } 
          
           catch (TransformerException ex) {
                Logger.getLogger(DocumentXML.class.getName()).log(Level.SEVERE, null, ex);
            }
           
           return false;
       }
}
