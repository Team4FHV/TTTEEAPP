/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Exceptions.BenutzerInaktivException;
import Exceptions.BenutzerNichtInDBException;
import Exceptions.FalschesPasswordExeption;
import Hibernate.objecte.Benutzer;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;

/**
 *
 * @author media
 */
public class UseCaseControllerLogin {
    private DataManager dm = new DataManager();
    private Benutzer benutzer;
    
    public UseCaseControllerLogin(){
        
    }
    
     public void login(String username, String passwort) throws BenutzerNichtInDBException, FalschesPasswordExeption, BenutzerInaktivException {
         benutzer = dm.getBentzerNachName(username);
         
        if (benutzer == null){
            throw new BenutzerNichtInDBException();
        } else if(benutzer.isAktiv()) {
        try {
            Hashtable env = new Hashtable();
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
            env.put(Context.SECURITY_PRINCIPAL, benutzer.getPasswort());
            env.put(Context.SECURITY_CREDENTIALS, passwort);
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, "ldaps://ldap.fhv.at:636/dc=uclv,dc=net");
            Context ctx = new InitialDirContext(env);
            ctx.close();
        } catch (NamingException ex) {
            Logger.getLogger(UseCaseControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
            throw new FalschesPasswordExeption();
        }
        }
        else
        {
            throw new BenutzerInaktivException();
        }
     }
     
      public Benutzer getBenutzer(){
          return benutzer;
      }
}
