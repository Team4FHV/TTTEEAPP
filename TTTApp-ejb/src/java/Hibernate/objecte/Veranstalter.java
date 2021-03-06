package Hibernate.objecte;
// Generated 28.10.2013 11:53:03 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Veranstalter generated by hbm2java
 */
public class Veranstalter  implements java.io.Serializable {


     private Integer veranstalterId;
     private String name;
     private String adresse;
     private String email;
     private String telefon;
     private boolean aktiv;
     private Set veranstaltungs = new HashSet(0);

    public Veranstalter() {
    }

	
    public Veranstalter(String name, String adresse, String email, String telefon, boolean aktiv) {
        this.name = name;
        this.adresse = adresse;
        this.email = email;
        this.telefon = telefon;
        this.aktiv = aktiv;
    }
    public Veranstalter(String name, String adresse, String email, String telefon, boolean aktiv, Set veranstaltungs) {
       this.name = name;
       this.adresse = adresse;
       this.email = email;
       this.telefon = telefon;
       this.aktiv = aktiv;
       this.veranstaltungs = veranstaltungs;
    }
   
    public Integer getVeranstalterId() {
        return this.veranstalterId;
    }
    
    public void setVeranstalterId(Integer veranstalterId) {
        this.veranstalterId = veranstalterId;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getAdresse() {
        return this.adresse;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefon() {
        return this.telefon;
    }
    
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public boolean isAktiv() {
        return this.aktiv;
    }
    
    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }
    public Set getVeranstaltungs() {
        return this.veranstaltungs;
    }
    
    public void setVeranstaltungs(Set veranstaltungs) {
        this.veranstaltungs = veranstaltungs;
    }




}


