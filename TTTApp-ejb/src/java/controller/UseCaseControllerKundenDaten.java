/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Domain.DAOFabrik;
import Exceptions.SaveFailedException;
import Hibernate.objecte.Kunde;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author media
 */
public class UseCaseControllerKundenDaten {
    
     private DataManager dataManager;
   

    public UseCaseControllerKundenDaten() {
    }
    
    public void neuenKundenSpeichern(String vorname, String nachname, Date geburtsdatum,  String anrede,
      String firmenname, String land, String postleitzahl, String ort, String strasse, String hausnummer, 
      String telefonnummer, String email) throws InstantiationException, IllegalAccessException, SaveFailedException{
        
       Set bestellungen= new HashSet(0);
       
       
      Kunde kunde =  DAOFabrik.getInstance().getKundeDAO().getHibernateClass().newInstance();
      kunde.setVorname(vorname);
      kunde.setNachname(nachname);
      kunde.setGeburtsdatum(geburtsdatum);
      kunde.setAnrede(anrede);
      kunde.setFirmenname(firmenname);
      kunde.setLand(land);
      kunde.setPostleitzahl(postleitzahl);
      kunde.setOrt(ort);
      kunde.setStrasse(strasse);
      kunde.setHausnummer(hausnummer);
      kunde.setTelefonnummer(telefonnummer);
      kunde.setEmail(email);
      kunde.setAktiv(true);
      kunde.setBestellungs(bestellungen);
      
      DAOFabrik.getInstance().getKundeDAO().saveORupdate(kunde);
      
    }
    
     public void kundenDatenAendern(int id, String vorname, String nachname, Date geburtsdatum,  String anrede,
      String firmenname, String land, String postleitzahl, String ort, String strasse, String hausnummer, 
      String telefonnummer, String email) throws InstantiationException, IllegalAccessException, SaveFailedException{
        
       
      Kunde kunde =  DAOFabrik.getInstance().getKundeDAO().findById(id, false);
      kunde.setVorname(vorname);
      kunde.setNachname(nachname);
      kunde.setGeburtsdatum(geburtsdatum);
      kunde.setAnrede(anrede);
      kunde.setFirmenname(firmenname);
      kunde.setLand(land);
      kunde.setPostleitzahl(postleitzahl);
      kunde.setOrt(ort);
      kunde.setStrasse(strasse);
      kunde.setHausnummer(hausnummer);
      kunde.setTelefonnummer(telefonnummer);
      kunde.setEmail(email);
      kunde.setAktiv(true);
      
      DAOFabrik.getInstance().getKundeDAO().saveORupdate(kunde);
      
    }
    
     
}
