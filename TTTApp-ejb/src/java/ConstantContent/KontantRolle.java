/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConstantContent;

import Domain.DAOFabrik;
import Hibernate.objecte.Rolle;

/**
 *
 * @author media
 */
public class KontantRolle {

    public static Rolle VERKAUF = DAOFabrik.getInstance().getRolleDAO().findById(4, false);
    public static Rolle ADMIN = DAOFabrik.getInstance().getRolleDAO().findById(1, false);
    public static Rolle DATENPFLEGE = DAOFabrik.getInstance().getRolleDAO().findById(2, false);
}
