package controller;

import DTO.objecte.DTOKarte;
import DTO.objecte.DTOKarteBestellen;
import DTO.objecte.DTOKarteReservieren;
import DTO.objecte.DTOKategorieInformation;
import DTO.objecte.DTOKategorieKarte;
import DTO.objecte.DTOKategorienAuswaehlen;
import DTO.objecte.DTOKundeNeuSpeichern;
import DTO.objecte.DTOKundenDaten;
import DTO.objecte.DTOLoginDaten;
import DTO.objecte.DTORollenList;
import DTO.objecte.DTOVeranstaltungAnzeigen;
import DTO.objecte.DTOVeranstaltungInformation;
import Domain.DAOFabrik;
import Domain.DAOGeneric;
import Domain.DAOObjekte.DAOKarte;
import Exceptions.BenutzerNichtInDBException;
import Exceptions.FalschesPasswordExeption;
import Exceptions.SaveFailedException;
import Hibernate.objecte.Benutzer;
import Hibernate.objecte.Bestellung;
import Hibernate.objecte.Karte;
import Hibernate.objecte.Kategorie;
import Hibernate.objecte.Kunde;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class HibernateTest {
	
	public static void main(String[] args) throws RemoteException, Exception {
            
            DataManager dm = new DataManager();
            System.out.println(dm.getKartenStatusId(161));
        
      //  Karte karte = DAOFabrik.getInstance().getKarteDAO().findById(161, false);
        
        UseCaseControllerBestellungErstellen b = new UseCaseControllerBestellungErstellen();
    //     System.out.println(b.istKartenStatusFrei(161));
       
        
        //    System.out.println("Karte id " + karte.getKartenId());
           //  Karte karte1 = DAOFabrik.getInstance().getKarteDAO().findById(23, false);
                    
         //  System.out.println("Karte1 id " + karte1.getKartenId());
           
//          RMIController con = new RMIController();
//          List<DTOKarteBestellen> list = new ArrayList<DTOKarteBestellen>();
//                 list.add(new DTOKarteBestellen(38, 2, true));
//         // con.verkaufSpeichern(list);
//                    con.verkaufSpeichern(list);

          
          
        //    UseCaseControllerKundenDaten uck= new UseCaseControllerKundenDaten();
//            Client c = new Client();
//                try {  
//             c.neuenKundeSpeichern
//                   (new DTOKundeNeuSpeichern (null, "Brick", new Date(), "Frau", "MMM", "Russland", "", "", "", "", "", ""));
//            
//                } catch (SaveFailedException ex){
//                    System.out.println(ex.toString());
//                }
//            
            //  Kunde kunde = DAOFabrik.getInstance().getKundeDAO().findById(1, true);
//            Benutzer benu = DAOFabrik.getInstance().getBenutzerDAO().findById(1, true);
//            Bestellung best = new Bestellung(benu, null, new Date());
//           
//             UseCaseControllerBestellungErstellen gj = new UseCaseControllerBestellungErstellen();
//              Karte k =  DAOFabrik.getInstance().getKarteDAO().findById(1, false);
//              Set<Karte> karten = new HashSet<>();
//              karten.add(k);
//             gj.verkaufSpeichern(benu, null, null);
            
//          DataManager m = new DataManager();
//            System.out.println("Iryna "+m.getBentzerNachName("ife7261").getNachname());
//           Kategorie kkkk = DAOFabrik.getInstance().getKategorieDAO().findById(1, false);
//          DTOKategorienAuswaehlen ka = new DTOKategorienAuswaehlen(kkkk.getKategorieId());
//          System.out.println( m.anzahlFreiePlatzeNachKategorie(kkkk));
//           System.out.println("rmikkk");
//           // System.out.println( m.getKuenstlerNachName("JonnyRonny"));
//            RMIController k = new RMIController();
//          
//            
//            System.out.println("RMI " + k.getAlleFreieKartenNachKategorie(ka).getDTOKarten().size());
//             for (DTOKarte ktsz : k.getAlleFreieKartenNachKategorie(ka).getDTOKarten()){
//                 System.out.println("karte"+ ktsz.getReihe() + "  " + ktsz.getPlatz());
//             }
//            
//             
//             System.out.println("Reservieren");
//             DTOKarteReservieren kr = new DTOKarteReservieren(13, 1, true);
//             List<DTOKarteReservieren> karten = new ArrayList<DTOKarteReservieren>();
//             karten.add(kr);
//             k.reservierungSpeichern(karten);
//           DTOKundenDaten kkkkkk = k.getKundendatenNachID(1);
//           
//            System.out.println(kkkkkk.getNachname());
           // ArrayList<DTOVeranstaltungInformation> ll =  k.sucheVeranstaltungenNachKrieterien(null, null, "JonnyRonny");
         //   System.out.println(ll.get(0).getKuenstler());
            
//            DTOVeranstaltungAnzeigen v = new DTOVeranstaltungAnzeigen(2);
//         ArrayList< DTOKategorieInformation> o =  k.getKategorieInfoVonVeranstaltung(v);
//            System.out.println(o.get(0).getPreis());
//             System.out.println(o.size());
//             
//              System.out.println(o.get(0).getFreieplätze());
//              
//              DTOVeranstaltungAnzeigen va = new DTOVeranstaltungAnzeigen(1);
//            
//           System.out.println( k.getKategorieInfoVonVeranstaltung(va).get(0).getPreis());
//           
           
            
            //Bestellung b = m.getReservierungNachID(1);
            //Kunde b = m.getKundeNachID(1);
            //System.out.println(b.getAnrede().toString() + b.getVorname());
            //UseCaseControllerSearch x = new UseCaseControllerSearch();
             //List y = x.searchFilter(null, "2013-11-01", "Winter Kommt ");
             //Veranstaltung z = (Veranstaltung)y.get(0);
             //z.setName("DDDD");
             
            //System.out.println(z.getDatumUhrzeit().toString());
            //System.out.println(y.size());
            //Rolle g= new Rolle("Super");
            //DAOFabrik.getInstance().getRolleDAO().saveORupdate(g);
            //List<Veranstaltung> c = 
             
             //Rolle g = DAOFabrik.getInstance().getRolleDAO().findById(4, true);
             //Benutzer b = DAOFabrik.getInstance().getBenutzerDAO().findById(1, true);
             //DAOFabrik.getInstance().getBenutzerDAO().addBenutzerRolle(b, g);
             //DAOFabrik.getInstance().getBenutzerDAO().saveORupdate(b);
//             
//             UseCaseControllerBestellungErstellen g = new UseCaseControllerBestellungErstellen();
//             System.out.println(g.getVeranstaltungByID(2).getName() + "veranstaltung");
//             
//             Karte k =  DAOFabrik.getInstance().getKarteDAO().findById(1, false);
//             
//             g.karteKaufen(k, true);
//             Kunde ku = DAOFabrik.getInstance().getKundeDAO().findById(1, false);
//             
//             
//             System.out.println(ku.getBestellungs().size());
//             System.out.println(g.getReservierteKartenVonKunde(ku).size());
            
               

            
       }	 

   
}