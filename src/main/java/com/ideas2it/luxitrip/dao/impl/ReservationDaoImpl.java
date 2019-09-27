package com.ideas2it.luxitrip.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ideas2it.luxitrip.dao.ReservationDao;
import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Bus;
import com.ideas2it.luxitrip.model.Schedule;
import com.ideas2it.luxitrip.model.Stop;

@Repository
public class ReservationDaoImpl  implements ReservationDao{
    
    @Autowired
    SessionFactory sessionFactory;

    public List<Bus> getBusesByOrigin(Stop origin) 
            throws CustomException{
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("Select Bus.id from Schedule s " 
                    + " INNER JOIN Midway m where m.stop = :stop",Bus.class)
                    .setParameter("stop",origin)
                    .list();
        } catch (HibernateException exception) {
            throw new CustomException("No buses available" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public List<Bus> getBusesByDestination(Stop destination) 
            throws CustomException{
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("Select Bus from Schedule" +
                    "INNER JOIN Midway m where m.Stop = :stop",Bus.class)
                    .setParameter("stop",destination)
                    .list();
        } catch (HibernateException exception) {
            throw new CustomException("No buses available" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}