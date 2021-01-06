/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoxml;

import DAOImpXML.DAOImpXMLVoiture;
import entites.*;
import factory.DocumentXML;
import org.w3c.dom.NodeList;
import service.XPATHService;

/**
 *
 * @author firas
 */
public class DAOXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
 
    	System.out.println("INSERTION DE DEUX VEHICULES \n");
        System.out.println("CREATION D'UN FICHIER XML VOITURE FROM DE SCRUSH \n");
       
       DAOImpXML.DAOImpXMLVoiture _DBFileVoiture=new DAOImpXMLVoiture();
        
        Voiture v1 = new Voiture(1,"Citroen ",new Achat("Janvier 2021",20000));
        Voiture v2 = new Voiture(2,"BMW ",new Achat("Decembre 2019",28000));
        Voiture v3 = new Voiture(3,"Mercedes ",new Achat("mars 1997",20000));
        Voiture v4 = new Voiture(4,"Renault ",new Achat("juillet 2018",28000));
       
        _DBFileVoiture.ajouterVoiture(v1);
        _DBFileVoiture.ajouterVoiture(v2);
        _DBFileVoiture.ajouterVoiture(v3);
        _DBFileVoiture.ajouterVoiture(v4);
       
        DocumentXML.saveVoitureDocument("Voitures.xml");
        
        System.out.println("FIN DE L'INSERTION DE DEUX VEHICULES \n");
        System.out.println("MODIFICATION DES VOITURES \n");
        
        v1.setModele("clio");
        v2.setModele("fiat");
        _DBFileVoiture.modifierVoiture(v1);
        _DBFileVoiture.modifierVoiture(v2);
        DocumentXML.saveVoitureDocument("Voitures.xml");
        System.out.println("SUPPRESSION DES VOITURES \n");
        
        _DBFileVoiture.removeVoiture(v4);
       DocumentXML.saveVoitureDocument("Voitures.xml");

    }
    
}
