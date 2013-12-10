/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO.objecte;

import java.io.Serializable;

/**
 *
 * Bürgi • Dietrich  • Fedorova  • Shabanova
 */

 public class DTOKarte implements Serializable{

	
	private static final long serialVersionUID = 2617784423536491789L;
    private int ID;
    private String reihe;
    private int platz;

    public DTOKarte(int ID, String reihe, int platz) {
        this.ID = ID;
        this.reihe = reihe;
        this.platz = platz;
    }

    public int getID() {
        return ID;
    }

    public String getReihe() {
        return reihe;
    }

    public int getPlatz() {
        return platz;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setReihe(String reihe) {
        this.reihe = reihe;
    }

    public void setPlatz(int platz) {
        this.platz = platz;
    }
    


}
