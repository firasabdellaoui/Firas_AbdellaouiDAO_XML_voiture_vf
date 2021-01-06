/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaoXML;

import entites.Voiture;
import org.w3c.dom.*;

/**
 *
 * @author firas
 */
public interface IDAOXMLVoiture {
    boolean ajouterVoiture(Node enfant, Voiture v);
    boolean ajouterVoiture(Voiture v);
    boolean modifierVoiture(Voiture v);
    boolean modifierVoiture(Node enfant, Voiture v);


}
