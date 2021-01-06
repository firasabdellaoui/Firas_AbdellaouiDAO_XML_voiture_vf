/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author firas
 */
public class XPATHService {

    public NodeList getNodesFromXpath(String path, Document xmlDocument) {
        NodeList nodeList=null;
        try {
            XPath xPath = XPathFactory.newInstance().newXPath();
            
            nodeList = (NodeList) xPath.compile(path).evaluate(xmlDocument, XPathConstants.NODESET);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(XPATHService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nodeList;
    }
public Number getNumberFromXpath(String path, Node xmlDocument) {
        Number nodeList=null;
        try {
            XPath xPath = XPathFactory.newInstance().newXPath();
            
            nodeList = (Number) xPath.compile(path).evaluate(xmlDocument, XPathConstants.NUMBER);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(XPATHService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nodeList;
    }
}
