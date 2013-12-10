/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Domain;

/**
 *
 * Bürgi • Dietrich  • Federova  • Shabanova
 */
import Domain.DAOObjekte.DAOBenutzer;
import Domain.DAOObjekte.DAOBestellung;
import Domain.DAOObjekte.DAOKarte;
import Domain.DAOObjekte.DAOKartenstatus;
import Domain.DAOObjekte.DAOKategorie;
import Domain.DAOObjekte.DAOKunde;
import Domain.DAOObjekte.DAOVeranstaltung;
import Domain.DAOObjekte.DAORolle;
import Hibernate.konfiguration.HibernateUtil;

import org.hibernate.Session;

public class DAOFabrik {

    	private static DAOFabrik _instance;

	/**
	 * Returns the globally useable {@link DAOFactory}.
	 * 
	 * @return the instance.
	 */
	public static DAOFabrik getInstance() {
		if (_instance == null) {
			_instance = new DAOFabrik();
		}
		return _instance;
               
	}

	
	public DAOVeranstaltung getVeranstaltungDAO() {
		return (DAOVeranstaltung) instantiateDAO(DAOVeranstaltung.class);
	}
        
        public DAOBestellung getBestellungDAO() {
		return (DAOBestellung) instantiateDAO(DAOBestellung.class);
	}
        
        public DAOKartenstatus getKartenstatusDAO() {
		return (DAOKartenstatus) instantiateDAO(DAOKartenstatus.class);
	}
        
        
        public DAOKarte getKarteDAO() {
		return (DAOKarte) instantiateDAO(DAOKarte.class);
	}
        
        public DAORolle getRolleDAO() {
		return (DAORolle) instantiateDAO(DAORolle.class);
	}
        
        public DAOKunde getKundeDAO() {
		return (DAOKunde) instantiateDAO(DAOKunde.class);
	}
        
        public DAOBenutzer getBenutzerDAO() {
		return (DAOBenutzer) instantiateDAO(DAOBenutzer.class);
	}
        
        public DAOKategorie getKategorieDAO() {
		return (DAOKategorie) instantiateDAO(DAOKategorie.class);
	}
        
	/**
	 * Creates a new DAO for the specified class.
	 * 
	 * @param daoClass
	 *            the type of the dao to be created
	 * @return the created an initialized dao.
	 */
	public DAOGeneric<?, ?> instantiateDAO(Class<?> daoClass) {
		try {
			DAOGeneric<?, ?> dao = (DAOGeneric<?, ?>) daoClass.newInstance();
			dao.setSession(getCurrentSession());
			return dao;
		} catch (Exception ex) {
			throw new RuntimeException("Can not instantiate DAO: " + daoClass,
					ex);
		}
	}

	/**
	 * Returns the current session to be assigned to all DAOs.
	 * 
	 * @return the current session.
	 */
	// You could override this if you don't want HibernateUtil for lookup
	public Session getCurrentSession() {
		return HibernateUtil.currentSession();
	}
}
    
    

