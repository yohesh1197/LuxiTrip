package com.ideas2it.luxitrip.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ideas2it.luxitrip.dao.BusDao;
import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Bus;

@Repository
public class BusDaoImpl implements BusDao{
	
    @Autowired
    private SessionFactory sessionFactory;
    
    public int insertBus(Bus bus) throws CustomException {
        int busId = 1;
        Session session = sessionFactory.openSession();
        System.out.println(session);
    	Transaction transact = null;
    	List<Bus> buses = new ArrayList<>();
    	try {
            transact = session.beginTransaction();
            busId = (int)session.save(bus);
            buses.add(bus);
            transact.commit();
        } catch (HibernateException exception) {
            if (transact!=null) {
                transact.rollback();
            }
            throw new CustomException("Bus already Exists" + exception);
        } catch (PersistenceException exception) {
            if (transact!=null) {
                transact.rollback();
            }
            throw new CustomException("Unable to add Bus " + exception);
        }  finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            } 
        }
        return busId;
    }
    
    @SuppressWarnings("unchecked")
    public List<Bus> getAllBuses() throws CustomException {
    	Session session = sessionFactory.openSession();
    	try {
            return (session.createQuery("FROM Bus").list()); 
    	} catch (HibernateException exception) {
            throw new CustomException("Unable to get Bus" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public Bus getBusById(int id) throws CustomException {
        Session session = sessionFactory.openSession();
        Bus bus = null;
        try {
            bus = session.get(Bus.class , id);
        } catch (HibernateException exception) {
            throw new CustomException("Unable to get Bus" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return bus;
    }
    
    /**
     * Replaces the entry with matching bus Id with the new data contained 
     * in the bus object
     * @param POJO object Bus to be updated in database table
     */    
    public void updateBus(Bus bus) throws CustomException{
        Session session = sessionFactory.openSession();
        Transaction transact = null;
        try {
            transact = session.beginTransaction();
            session.update(bus); 
            transact.commit();
        } catch (HibernateException exception) {
            if (transact!=null) {
                transact.rollback();
            }
            throw new CustomException("Unable to update Bus" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            } 
        }
    }
    
    /**
     * Deletes the bus by setting the status to false
     * @param Bus object which is to be deleted
     */
    public void deleteBus(Bus bus) throws CustomException{
        Session session = sessionFactory.openSession();
        Transaction transact = null;
        try {
            transact = session.beginTransaction();
            session.update(bus);
            transact.commit();
        } catch (HibernateException exception) {
            if (transact!=null) {
                transact.rollback();
            }
            throw new CustomException("Unable to Delete Bus" + exception);
        } finally {
            try {
                session.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
