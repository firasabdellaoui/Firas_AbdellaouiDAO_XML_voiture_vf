/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import org.w3c.dom.*;

/**
 *
 * @author firas
 */
public class Achat {

   public void toXML(Document doc, Node parent)
   {
       // elementt <voiture>
        Element elAchat = doc.createElement("achat");
        parent.appendChild(elAchat);
        Element elDate = doc.createElement("date");
        elDate.appendChild(doc.createTextNode(date));
        elAchat.appendChild(elDate);
        Element elPrix = doc.createElement("prix");
        elPrix.appendChild(doc.createTextNode(Float.toString(prix)));
        elAchat.appendChild(elDate);
        
   }
    private String date;
    private float prix;

    public Achat() {
    }

    public Achat(String date, float prix) {
        this.date = date;
        this.prix = prix;
    }
    
     public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
    
}
