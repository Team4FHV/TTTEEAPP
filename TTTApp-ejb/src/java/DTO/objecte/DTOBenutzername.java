/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO.objecte;

import java.io.Serializable;

/**
 *
 * @author Monika
 */
public class DTOBenutzername implements Serializable{
    
    private String benutzername;

    public DTOBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }
}
