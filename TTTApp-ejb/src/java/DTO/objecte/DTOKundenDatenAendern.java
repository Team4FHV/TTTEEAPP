/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO.objecte;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author media
 */
public class DTOKundenDatenAendern implements Serializable{

    private int id;
    private String vorname;
    private String nachname;
    private Date geburtsdatum;
    private String anrede;
    private String firmenname;
    private String land;
    private String postleitzahl;
    private String ort;
    private String strasse;
    private String hausnummer;
    private String telefonnummer;
    private String email;

    public DTOKundenDatenAendern() {
    }

    public DTOKundenDatenAendern(int id, String vorname, String nachname, Date geburtsdatum, String anrede, String firmenname, String land, String postleitzahl, String ort, String strasse, String hausnummer, String telefonnummer, String email) {
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatum;
        this.anrede = anrede;
        this.firmenname = firmenname;
        this.land = land;
        this.postleitzahl = postleitzahl;
        this.ort = ort;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.telefonnummer = telefonnummer;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public Date getGeburtsdatum() {
        return geburtsdatum;
    }

    public String getAnrede() {
        return anrede;
    }

    public String getFirmenname() {
        return firmenname;
    }

    public String getLand() {
        return land;
    }

    public String getPostleitzahl() {
        return postleitzahl;
    }

    public String getOrt() {
        return ort;
    }

    public String getStrasse() {
        return strasse;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public String getEmail() {
        return email;
    }
}
