/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO.objecte;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * Bürgi • Dietrich • Fedorova • Shabanova
 */
public class DTOVeranstaltungInformation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2617784423536491789L;

    private Date d;
    private String ort;
    private String kuenstler;
    private String name;
    private int id;

    public DTOVeranstaltungInformation(Date d, String ort, String kuenstler, int id, String name) {
        this.d = d;
        this.ort = ort;
        this.kuenstler = kuenstler;
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getD() {
        return d;
    }

    public String getOrt() {
        return ort;
    }

    public String getKuenstler() {
        return kuenstler;
    }

    public void setD(Date d) {
        this.d = d;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public void setKuenstler(String kuenstler) {
        this.kuenstler = kuenstler;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
