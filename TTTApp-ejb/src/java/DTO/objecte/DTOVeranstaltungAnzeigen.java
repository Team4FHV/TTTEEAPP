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
public class DTOVeranstaltungAnzeigen implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2617784423536491789L;

    private int id;
    
    public DTOVeranstaltungAnzeigen(int id) {
        this.id= id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
