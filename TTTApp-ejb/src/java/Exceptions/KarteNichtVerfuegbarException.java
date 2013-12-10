/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author media
 */
public class KarteNichtVerfuegbarException extends Exception{
    private int kartenId;
   
    public KarteNichtVerfuegbarException(int id){
        kartenId  = id;

    }
    
    public int getKartenId(){
        return kartenId;
    }
    
    
}
