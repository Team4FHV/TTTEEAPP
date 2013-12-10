/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Domain.DAOObjekte;

import Domain.DAOFabrik;
import Domain.DAOGeneric;
import Hibernate.objecte.Benutzer;
import Hibernate.objecte.Rolle;

/**
 *
 * Bürgi • Dietrich  • Federova  • Shabanova
 */
public class DAOBenutzer extends DAOGeneric < Benutzer, Long >{
    
    public void addBenutzerRolle(Benutzer b ,Rolle r) {
          b.getRolles().add(r);
         
  }

    
}
