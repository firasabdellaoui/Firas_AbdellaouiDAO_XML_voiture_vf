/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import org.w3c.dom.*;


import static java.lang.Integer.parseInt;

import java.io.FileInputStream;


import java.io.StringWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import javax.xml.transform.Transformer;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;






/**
 * @author firas
 */

public class Voiture {

    public void toXML(Document doc, Node node, TypeNode typeNode) {
        // element <voiture>
        if (typeNode == TypeNode.enfant) {
            Element elVoiture = doc.createElement("voiture");
            // membre id sous la forme d'un attribut
            elVoiture.setAttribute("id", Integer.toString(id));
            // membre modele sous la forme d'un element
            Element elModele = doc.createElement("modele");
            elModele.appendChild(doc.createTextNode(modele));
            elVoiture.appendChild(elModele);
            // membre achat par un appel récursif
            achat.toXML(doc, elVoiture);
            node.getParentNode().insertBefore(elVoiture, node);

        }
    }

    public void toXML(Document doc) {
        // element <voiture>
        Element elVoiture = doc.createElement("voiture");
        Element racine = doc.getDocumentElement();
        racine.appendChild(elVoiture);
        // membre id sous la forme d'un attribut
        elVoiture.setAttribute("id", Integer.toString(id));
        // membre modele sous la forme d'un element
        Element elModele = doc.createElement("modele");
        elModele.appendChild(doc.createTextNode(modele));
        elVoiture.appendChild(elModele);
        // membre achat par un appel récursif
        achat.toXML(doc, elVoiture);
    }

    public void UpdatetoXML(Document doc, Node node, TypeNode typeNode) {
        if (typeNode == TypeNode.enfant) {
            Element elVoiture = doc.createElement("voiture");
            elVoiture.setAttribute("id", Integer.toString(id));
            Element elModele = doc.createElement("modele");
            elModele.appendChild(doc.createTextNode(modele));
            elVoiture.appendChild(elModele);
            NodeList nl = node.getChildNodes();
            for (int i = 0; i < nl.getLength(); i++) {
                if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) nl.item(i);
                    if (parseInt(el.getAttribute("id")) == this.getId()) {
                        node.replaceChild(elVoiture, el);
                        break;
                    }
                }
            }
        }
    }
public void remove(Document doc) throws Exception {
	// DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    // dbf.setValidating(false);
   //  DocumentBuilder db = dbf.newDocumentBuilder();
    //  
     //Document doc1 = db.parse(new FileInputStream(new File("Voitures.xml")));
      
	 NodeList nl = doc.getElementsByTagName("voiture");
     Element element = (Element) doc.getElementsByTagName("voiture").item(0);
    
  
     element.getParentNode().removeChild(element);
  
     doc.normalize();
      
     prettyPrint(doc);
     System.out.println("Voiture supprimer avec succées\n");
	
}
public static final void prettyPrint(Document xml) throws Exception {
    Transformer tf = TransformerFactory.newInstance().newTransformer();
    tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
    tf.setOutputProperty(OutputKeys.INDENT, "yes");
    Writer out = new StringWriter();
    tf.transform(new DOMSource(xml), new StreamResult(out));
    System.out.println(out.toString());
}
    public void UpdatetoXML(Document doc) {
        {
            NodeList nl = doc.getElementsByTagName("voiture");
            for (int i = 0; i < nl.getLength(); i++) {
                if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) nl.item(i);
                    System.out.println(el.getTextContent());

                    if (parseInt(el.getAttribute("id")) == this.getId()) {
                        NodeList list = el.getChildNodes();
                        for (int j = 0; j < list.getLength(); j++) {
                            Node node = list.item(j);
                            if ("modele".equals(node.getNodeName())) {
                                node.setTextContent(this.getModele());
                            }
                            System.out.println("Voiture modifier avec succées\n");
                        }
                    }


                }
            }

        }
    }

    private int id;
    private String modele;
    private Achat achat;

    public Voiture(int id, String modele, Achat prix) {
        this.id = id;
        this.modele = modele;
        this.achat = prix;
    }

    public Voiture() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Achat getAchat() {
        return achat;
    }

    public void setAchat(Achat achat) {
        this.achat = achat;
    }

}
