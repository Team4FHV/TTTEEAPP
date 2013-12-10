/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Domain.DAOObjekte;

import Domain.DAOGeneric;
import Hibernate.konfiguration.HibernateUtil;
import Hibernate.objecte.Veranstaltung;
import java.util.ArrayList;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import java.util.List;
import org.hibernate.Session;
/**
 *
 * Bürgi • Dietrich  • Federova  • Shabanova
 */
public class DAOVeranstaltung extends DAOGeneric < Veranstaltung, Long >{

    
    	public List<Veranstaltung> sucheVeranstaltungNach( ArrayList<Veranstaltung> exampleVeranstaltungs, int maxResults) {
				Disjunction criterion = Restrictions.disjunction();

		for (Veranstaltung client : exampleVeranstaltungs) {
			Example ex = Example.create(client);
			ex.ignoreCase();
			ex.excludeZeroes();
			ex.enableLike(MatchMode.ANYWHERE);
			//ex.setCombiningMode(CombiningMode.Disjunction);
			criterion.add(ex);
		}

		Session session = HibernateUtil.currentSession();

		@SuppressWarnings("unchecked")
		List<Veranstaltung> List = session.createCriteria(Veranstaltung.class)
				.add(criterion).setMaxResults(maxResults).list();

		return List;
	}
        
      
      
}
