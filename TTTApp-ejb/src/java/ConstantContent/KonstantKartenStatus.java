/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ConstantContent;

import Domain.DAOFabrik;
import Hibernate.objecte.Kartenstatus;

/**
 *
 * Bürgi • Dietrich  • Federova  • Shabanova
 */
public class KonstantKartenStatus {

    public static Kartenstatus FREI = DAOFabrik.getInstance().getKartenstatusDAO().findById(3, false);
    public static Kartenstatus VERKAUFT = DAOFabrik.getInstance().getKartenstatusDAO().findById(1, false);
    public static Kartenstatus RESERVIERT = DAOFabrik.getInstance().getKartenstatusDAO().findById(2, false);
    public static Kartenstatus BLOKIERT = DAOFabrik.getInstance().getKartenstatusDAO().findById(4, false);
    
}
