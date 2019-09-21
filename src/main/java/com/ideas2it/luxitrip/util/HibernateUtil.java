package com.ideas2it.luxitrip.util;

import com.ideas2it.luxitrip.exception.UserException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * This is a utility class for getting the hibernate session object.
 * @author java with ease
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();    
            System.out.println(sessionFactory);  
        }
        catch (Exception e) {
          System.out.println("Unable to build session factory");
        }
        return sessionFactory;
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
