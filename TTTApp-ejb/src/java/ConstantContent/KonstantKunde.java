/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConstantContent;

import Domain.DAOFabrik;
import Hibernate.objecte.Kunde;

/**
 *
 * @author media
 */

// Bei anonymen Kauf Verkauf wird gespeichert für Kunde mit ID nummer 1 - Anonymus
public class KonstantKunde {
        public static Kunde ANONYMOUS = DAOFabrik.getInstance().getKundeDAO().findById(1, false);

}
