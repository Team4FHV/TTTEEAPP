package Hibernate.objecte;
// Generated 28.10.2013 11:53:03 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Veranstaltungsort generated by hbm2java
 */
public class Veranstaltungsort  implements java.io.Serializable {


     private Integer veranstaltungsortId;
     private String name;
     private String adresse;
     private String beschreibung;
     private Set veranstaltungs = new HashSet(0);

    public Veranstaltungsort() {
    }

	
    public Veranstaltungsort(String name, String adresse) {
        this.name = name;
        this.adresse = adresse;
    }
    public Veranstaltungsort(String name, String adresse, String beschreibung, Set veranstaltungs) {
       this.name = name;
       this.adresse = adresse;
       this.beschreibung = beschreibung;
       this.veranstaltungs = veranstaltungs;
    }
   
    public Integer getVeranstaltungsortId() {
        return this.veranstaltungsortId;
    }
    
    public void setVeranstaltungsortId(Integer veranstaltungsortId) {
        this.veranstaltungsortId = veranstaltungsortId;
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
    public String getBeschreibung() {
        return this.beschreibung;
    }
    
    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
    public Set getVeranstaltungs() {
        return this.veranstaltungs;
    }
    
    public void setVeranstaltungs(Set veranstaltungs) {
        this.veranstaltungs = veranstaltungs;
    }




}


