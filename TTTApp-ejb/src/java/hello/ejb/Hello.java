/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hello.ejb;

import ConstantContent.KonstantKartenStatus;
import ConstantContent.KonstantKunde;
import ConstantContent.KontantRolle;
import DTO.objecte.DTOKarte;
import DTO.objecte.DTOKarteBestellen;
import DTO.objecte.DTOKarteReservieren;
import DTO.objecte.DTOKategorieInformation;
import DTO.objecte.DTOKategorieKarte;
import DTO.objecte.DTOKategorienAuswaehlen;
import DTO.objecte.DTOKundeNeuSpeichern;
import DTO.objecte.DTOKundenDaten;
import DTO.objecte.DTOKundenDatenAendern;
import DTO.objecte.DTOLoginDaten;
import DTO.objecte.DTORollenList;
import DTO.objecte.DTOVeranstaltung;
import DTO.objecte.DTOVeranstaltungAnzeigen;
import DTO.objecte.DTOVeranstaltungInformation;
import Domain.DAOFabrik;
import Exceptions.BenutzerInaktivException;
import Exceptions.BenutzerNichtInDBException;
import Exceptions.FalschesPasswordExeption;
import Exceptions.KarteNichtVerfuegbarException;
import Exceptions.SaveFailedException;
import Hibernate.objecte.Benutzer;
import Hibernate.objecte.Karte;
import Hibernate.objecte.Kategorie;
import Hibernate.objecte.Kuenstler;
import Hibernate.objecte.Kunde;
import Hibernate.objecte.Rolle;
import Hibernate.objecte.Veranstaltung;
import controller.DataManager;
import controller.UseCaseControllerBestellungErstellen;
import controller.UseCaseControllerKundenDaten;
import controller.UseCaseControllerLogin;
import controller.UseCaseControllerSearch;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateful;

/**
 *
 * @author Anastasia
 */
@Stateful
public class Hello implements HelloRemote {
 private UseCaseControllerLogin ucl;
    private UseCaseControllerBestellungErstellen ucb;
    private UseCaseControllerSearch ucs;
    private UseCaseControllerKundenDaten uck;
    private DataManager<Object> dm;
    private Benutzer benutzer;

    public Hello() {
        super();
        ucl = new UseCaseControllerLogin();
        ucb = new UseCaseControllerBestellungErstellen();
        ucs = new UseCaseControllerSearch();
        uck = new UseCaseControllerKundenDaten();
        dm = new DataManager<>();
        benutzer = null;
    }

    @Override
    public DTORollenList login(DTOLoginDaten l) throws BenutzerNichtInDBException, FalschesPasswordExeption {
        try {
            ucl.login(l.getUsername(), l.getPasswort());
        } catch (BenutzerNichtInDBException ex) {
            Logger.getLogger(BenutzerNichtInDBException.class.getName()).log(Level.SEVERE, null, ex);
            throw new BenutzerNichtInDBException();
        } catch (FalschesPasswordExeption ex) {
            Logger.getLogger(BenutzerNichtInDBException.class.getName()).log(Level.SEVERE, null, ex);
            throw new FalschesPasswordExeption();
        } catch (BenutzerInaktivException ex) {
            Logger.getLogger(BenutzerNichtInDBException.class.getName()).log(Level.SEVERE, null, ex);
        }
        benutzer = ucl.getBenutzer();

        ArrayList<String> list = new ArrayList();
        Object[] rollen = benutzer.getRolles().toArray();
        for (int i = 0; i < rollen.length; i++) {
            list.add(((Rolle) rollen[i]).getName());
            System.out.println("rolle ad in list" + list.get(i));
        }
        return new DTORollenList(list);
    }

    @Override
    public void neuenKundenSpeichern(DTOKundeNeuSpeichern k) throws SaveFailedException {
        if (benutzer != null && benutzer.getRolles().contains(KontantRolle.DATENPFLEGE)) {
            try {
                try {
                    uck.neuenKundenSpeichern(k.getVorname(), k.getNachname(), k.getGeburtsdatum(), k.getAnrede(),
                            k.getFirmenname(), k.getLand(), k.getPostleitzahl(), k.getOrt(), k.getStrasse(), k.getHausnummer(),
                            k.getTelefonnummer(), k.getEmail());
                } catch (SaveFailedException ex) {
                    Logger.getLogger(SaveFailedException.class.getName()).log(Level.SEVERE, null, ex);
                    throw new SaveFailedException();
                }

            } catch (InstantiationException ex) {
                Logger.getLogger(InstantiationException.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(IllegalAccessException.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void kundenDatenAendern(DTOKundenDatenAendern k) throws SaveFailedException {
        if (benutzer != null && benutzer.getRolles().contains(KontantRolle.DATENPFLEGE)) {
            try {

                uck.kundenDatenAendern(k.getId(), k.getVorname(), k.getNachname(), k.getGeburtsdatum(), k.getAnrede(),
                        k.getFirmenname(), k.getLand(), k.getPostleitzahl(), k.getOrt(), k.getStrasse(), k.getHausnummer(),
                        k.getTelefonnummer(), k.getEmail());
            } catch (InstantiationException ex) {
                Logger.getLogger(InstantiationException.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(IllegalAccessException.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    public ArrayList<DTOVeranstaltungInformation> sucheVeranstaltungenNachKrieterien(Date d, String ort, String kuenstler) 
            {
        ArrayList<DTOVeranstaltungInformation> veranstaltungDTOList = new ArrayList<DTOVeranstaltungInformation>();
        if (d == null) {
            d = new Date();
        }
        Kuenstler k;
        if (kuenstler != null) {
            k = dm.getKuenstlerNachName(kuenstler);
        } else {
            k = null;
        }

        List<Veranstaltung> veranstaltungList = ucs.searchFilter(ort, d, k);
        for (Veranstaltung v : veranstaltungList) {
            Object[] ku = v.getKuenstlers().toArray();

            String kuenstlerList = "";

            for (int i = 0; i < ku.length; i++) {
                Kuenstler kk = (Kuenstler) ku[i];
                kuenstlerList += kk.getName() + " ";
            }

            veranstaltungDTOList.add(new DTOVeranstaltungInformation(v.getDatumUhrzeit(), v.getVeranstaltungsort().getAdresse(), kuenstlerList, v.getVeranstaltungId(), v.getName()));
        }

        return veranstaltungDTOList;
    }

    @Override
    public ArrayList<DTOKategorieInformation> getKategorieInfoVonVeranstaltung(DTOVeranstaltungAnzeigen v) 
            {
        ArrayList<DTOKategorieInformation> kategorieDTOList = new ArrayList<>();

        Veranstaltung veranstaltung = ucb.getVeranstaltungByID(v.getId());

        Object[] kat = veranstaltung.getKategories().toArray();
        for (int i = 0; i < kat.length; i++) {
            Kategorie k = (Kategorie) kat[i];
            int ermaessigung = k.getVeranstaltung().getErmaessigung();
            int frei = dm.anzahlFreiePlatzeNachKategorie(k);
            kategorieDTOList.add(new DTOKategorieInformation(k.getKategorieId(), k.getName(), k.getPreis(), frei, ermaessigung));
        }
        return kategorieDTOList;
    }

    @Override
    public DTOKategorieInformation getKategorieInfo(int id) {
        Kategorie kat = ucb.getKategorieByID(id);
        int ermaessigung = kat.getVeranstaltung().getErmaessigung();
        int frei = dm.anzahlFreiePlatzeNachKategorie(kat);
        return new DTOKategorieInformation(kat.getKategorieId(), kat.getName(), kat.getPreis(), frei, ermaessigung);
    }

    @Override
    public DTOKategorieKarte getAlleFreieKartenNachKategorie(DTOKategorienAuswaehlen kat) {

        Kategorie k = ucb.getKategorieByID(kat.getId());
        List<DTOKarte> kartenDTOList = new ArrayList<>();
        List<Karte> karten = ucb.getFreieKartenNachKategorie(k);
        if (karten != null) {
            for (Karte karte : karten) {
                kartenDTOList.add(new DTOKarte(karte.getKartenId(), karte.getReihe(), karte.getSitzplatz()));
                System.out.println("KARTEN gefunden id=" + karte.getKartenId());
            }
        }
        return new DTOKategorieKarte(kartenDTOList);
    }

    @Override
    public ArrayList<DTOKundenDaten> getKundenListNachNachname(String nachname) throws Exception {
        ArrayList<Kunde> kundenlist = ucb.kundeSuchen(nachname);
        ArrayList<DTOKundenDaten> kundenDTOlist = new ArrayList<>();
        if (kundenlist == null || kundenlist.size() == 0) {
            throw new Exception("Kein Kunde gefunden");
        } else {
            for (Kunde k : kundenlist) {
                kundenDTOlist.add(new DTOKundenDaten(k.getKundenId(), k.getVorname(), k.getNachname(), k.getGeburtsdatum()));
            }
        }
        return kundenDTOlist;
    }

    @Override
    public DTOKundenDaten getKundendatenNachID(int id) throws Exception {
        Kunde k = ucb.getKundeByID(id);
        if (k == null) {
            throw new Exception("Kein Kunde gefunden");
        }

        return new DTOKundenDaten(k.getKundenId(), k.getVorname(), k.getNachname(), k.getGeburtsdatum());
    }

    @Override
    public void verkaufSpeichern(List<DTOKarteBestellen> karten) throws Exception, RemoteException, SaveFailedException, KarteNichtVerfuegbarException {
        Set<Karte> bestellteKartenSet = new HashSet<>();
        int statusFREI = KonstantKartenStatus.FREI.getKartenstatusId();
        int kundenId = 0;
        if (karten != null) {
            kundenId = karten.get(0).getKundenID();
        }
        Kunde kunde = null;
        if (kundenId != -1) {
            kunde = ucb.getKundeByID(kundenId);
        }
        if (kundenId == -1) {
            kunde = KonstantKunde.ANONYMOUS;
        }
        if (karten != null) {

            for (DTOKarteBestellen b : karten) {
                Karte k = ucb.getKarteByID(b.getKartenID());
                DAOFabrik.getInstance().getKarteDAO().saveORupdate(k);
                System.out.println("UHRA ");
                     System.out.println(dm.getKartenStatusId(k.getKartenId()));
                     System.out.println(statusFREI);
                if (dm.getKartenStatusId(k.getKartenId())== statusFREI) {
                    ucb.karteKaufen(k, b.isErmaessigt());
                    bestellteKartenSet.add(k);
                } else {
                    ucb.kartenFreiGeben(bestellteKartenSet);
                    throw new KarteNichtVerfuegbarException(k.getKartenId());
                }
            } 
            ucb.verkaufSpeichern(benutzer, kunde, bestellteKartenSet);
        }
    }

    @Override
    public void reservierungSpeichern(List<DTOKarteReservieren> karten) throws Exception, SaveFailedException, KarteNichtVerfuegbarException {
        Set<Karte> bestellteKartenSet = new HashSet<>();
        int kundenId = karten.get(0).getKundenID();
        int statusFREI = KonstantKartenStatus.FREI.getKartenstatusId();

        Kunde kunde = null;
        if (kundenId != -1) {
            kunde = ucb.getKundeByID(kundenId);
        } else {
            throw new Exception("Kein Kunde gefunden -- reservieren");
        }
        if (karten != null) {

            for (DTOKarteReservieren b : karten) {
                Karte k = ucb.getKarteByID(b.getKartenID());
                if (dm.getKartenStatusId(k.getKartenId()) == statusFREI) {
                    ucb.karteReservieren(k);
                    bestellteKartenSet.add(k);
                } else {
                    ucb.kartenFreiGeben(bestellteKartenSet);
                    throw new KarteNichtVerfuegbarException(k.getKartenId());
                }
            }
            ucb.verkaufSpeichern(benutzer, kunde, bestellteKartenSet);
        }
    }

    @Override
    public DTOVeranstaltung getVeranstaltungById(int veranstaltungID) {
        Veranstaltung v = ucb.getVeranstaltungByID(veranstaltungID);
        String Vname = v.getName();
        String VOrt = v.getVeranstaltungsort().getAdresse();
        Date date = v.getDatumUhrzeit();

        boolean ermaessigt = (v.getErmaessigung() == 0);
        return new DTOVeranstaltung(veranstaltungID, Vname, VOrt, date, ermaessigt);
    }
}
