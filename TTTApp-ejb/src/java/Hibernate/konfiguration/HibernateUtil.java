/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate.konfiguration;

import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;




/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Anastasia
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    public static final ThreadLocal<Session> MAP  = new ThreadLocal<Session>();

           private HibernateUtil()  {}
           
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file. All Files	
           
            
            sessionFactory = new Configuration().configure().buildSessionFactory();
            
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static Session currentSession() throws HibernateException
    {
        Session s = (Session) MAP.get();
        // Open a new Session, if this Thread has none yet
        if (s == null)
        {
            s = sessionFactory.openSession();
            MAP.set(s);
        }
        return s;
    }

    /**
	 
	 */
    public static void closeSession() throws HibernateException
    {
        Session s = (Session) MAP.get();
        MAP.set(null);
        if (s != null)
        {
            s.close();
        }
    }
}
