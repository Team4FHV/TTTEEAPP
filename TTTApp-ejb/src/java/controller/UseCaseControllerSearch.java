/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import Domain.DAOFabrik;
import Hibernate.objecte.Kuenstler;
import Hibernate.objecte.Veranstaltung;
import Hibernate.objecte.Veranstaltungsort;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * Bürgi • Dietrich  • Fedorova  • Shabanova
 */
public class UseCaseControllerSearch {

    List<Veranstaltung> ver = DAOFabrik.getInstance().getVeranstaltungDAO().findAll();

    
   
     
   public List<Veranstaltung> searchFilter(String ort, Date data, Kuenstler kun) {
               
         
                List<Veranstaltung> veranstal = ver;
                if(ort!=null){
                      veranstal= this.sucheVeranstaltungNachORT(veranstal, ort);
                
                }
		if(data!=null){
                      veranstal= this.sucheVeranstaltungNachDatum(veranstal, data);
                
                }
		if(kun!=null){
                    veranstal= this.sucheVeranstaltungKunstler(veranstal, kun);
                
                }
			
		return veranstal;
	}
   
          public List<Veranstaltung> sucheVeranstaltungNachORT( List<Veranstaltung> Veranstaltungs, String ort) {
	 
            List<Veranstaltung> List = new ArrayList<Veranstaltung>();	
           
        for (Veranstaltung v : Veranstaltungs) {
		if(v.getVeranstaltungsort().getAdresse().contains(ort))
            List.add(v);
               
            }
     		return List;
	}
        
          public List<Veranstaltung> sucheVeranstaltungNachDatum( List<Veranstaltung> Veranstaltungs, Date Resultat) {
	 
            List<Veranstaltung> List = new ArrayList<Veranstaltung>();	
           
        for (Veranstaltung v : Veranstaltungs) {
                            
                if((v.getDatumUhrzeit().after(Resultat))||((v.getDatumUhrzeit().equals(Resultat)))){
            List.add(v);
           
            }
        }
     		return List;
	}
          
          public List<Veranstaltung> sucheVeranstaltungKunstler(List<Veranstaltung> Veranstaltungs, Kuenstler Resultat) {
	 
            List<Veranstaltung> List = new ArrayList<Veranstaltung>();	
           
        for (Veranstaltung v : Veranstaltungs) {
		if(v.getKuenstlers().contains(Resultat)){
            List.add(v);
                }
        }
     		return List;
	}
}
