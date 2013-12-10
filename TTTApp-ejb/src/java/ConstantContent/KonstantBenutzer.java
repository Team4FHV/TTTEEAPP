/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConstantContent;

import Domain.DAOFabrik;
import Hibernate.objecte.Benutzer;

/**
 *
 * @author media
 */
public class KonstantBenutzer {
        public static Benutzer EXTERN = DAOFabrik.getInstance().getBenutzerDAO().findById(6, false);

    
}
