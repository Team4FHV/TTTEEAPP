/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO.objecte;

import java.io.Serializable;
import java.util.List;

/**
 *
 * Bürgi • Dietrich  • Fedorova  • Shabanova
 */
public class DTOKategorieKarte implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2617784423536491789L;
List<DTOKarte>  DTOKarten;

    public DTOKategorieKarte(List<DTOKarte> DTOKarten) {
        this.DTOKarten = DTOKarten;
    }

    public List<DTOKarte> getDTOKarten() {
        return DTOKarten;
    }

    public void setDTOKarten(List<DTOKarte> DTOKarten) {
        this.DTOKarten = DTOKarten;
    }


}
