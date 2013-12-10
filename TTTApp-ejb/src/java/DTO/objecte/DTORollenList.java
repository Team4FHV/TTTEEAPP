/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO.objecte;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author media
 */
public class DTORollenList implements Serializable{
    ArrayList<String> rollen = new ArrayList();

    public DTORollenList(ArrayList<String> rollen) {
         this.rollen = rollen;
    }

    public ArrayList<String> getRollen() {
        return rollen;
    }

   
    
    
}
