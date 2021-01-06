/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpXML
;

import entites.TypeNode;
import entites.Voiture;
import factory.DocumentXML;
import idaoXML.IDAOXMLVoiture;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 *
 * @author firas
 */
public class DAOImpXMLVoiture implements IDAOXMLVoiture {

    Document doc;
    public DAOImpXMLVoiture()
    {
        doc=DocumentXML.getVoitureDocument();
    }
    public DAOImpXMLVoiture(String path)
    {
        doc=DocumentXML.getVoitureDocument(path);
    }
    @Override
    public boolean ajouterVoiture(Node enfant, Voiture v) {
        try
        {
            v.toXML(doc, enfant,TypeNode.enfant);
        }
        catch(Exception ex)
        {
            return false;
        }
        return true;
    }
    

    @Override
    public boolean ajouterVoiture(Voiture v) {
        try
        {
        v.toXML(doc);
        }
        catch(Exception ex)
        {
            return false;
        }
        return true;
    }
    public boolean modifierVoiture(Node enfant, Voiture v){
        try
        {
            v.UpdatetoXML(doc,  enfant, TypeNode.parent);

        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return false;
        }
        return true;    }
    
    public boolean removeVoiture(Voiture v){
        try
        {
            v.remove(doc);

        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return false;
        }
        return true;    }
    @Override
    public boolean modifierVoiture(Voiture v) {
        try
        {
            v.UpdatetoXML(doc);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return false;
        }
        return true;
    }

}
