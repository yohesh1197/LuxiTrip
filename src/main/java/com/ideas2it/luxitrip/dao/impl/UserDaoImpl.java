package com.ideas2it.luxitrip.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;    
import org.hibernate.Session;    
import org.hibernate.SessionFactory;    
import org.hibernate.Transaction;  
import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;

import com.ideas2it.luxitrip.model.User;
import com.ideas2it.luxitrip.exception.UserException;
import com.ideas2it.luxitrip.dao.UserDao;


@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

	/**
	 * Method used to register the userDetail from user into the database 
	 * @param user
	 * @throws UserException
	 */
	public void insertUser(User user)throws UserException {
	    Session session = sessionFactory.openSession();
	    Transaction transaction = null;
	    try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (HibernateException ex) {
            throw new UserException("Unable to add " + user.getId() + " value" + ex);
        } finally {
            try {
                session.close(); 
            } catch(Exception ex) {
                throw new UserException("Unable to close session");
            }
        }
    } 
	
	/**
	 * Method used to update the user value in the userId from user into the database 
	 * @param user
	 * @throws UserException
	 */
	public void updateUser(User user)throws UserException {
	    Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
		    transaction = session.beginTransaction();
		    session.saveOrUpdate(user);
		    transaction.commit();
		} catch(HibernateException ex) {
			throw new UserException("Unable to update" + user.getId() + "values");
		} finally {
			try {
				session.close();
			} catch(Exception ex) {
				throw new UserException("Unable to close session");
			}
		}
	}
	
	/** 
	 * Method used to get the List of users from the database
	 * @throws UserException
	 */
    public List<User> getUsers() throws UserException {
	    List<User> users = new ArrayList<User>();
	    Session session = sessionFactory.openSession();
	    try{    
	        Query query = session.createQuery("from User");
	        users = query.list();
	    } catch(HibernateException ex) {
	        throw new UserException("Unable to get all users");
	    } finally {
	        try {
	            session.close(); 
	        } catch(HibernateException ex) {
	            throw new UserException("Unable to close session");
	        }
	    }
	    return users;        
	}
	 
    /**
     * Method used to get the User detail by using the userId  
     * @param userId
     * @return the user detail 
     * @throws UserException
     */
    public User getUserById(int id) throws UserException {
	    Session session = sessionFactory.openSession();
    	try {
            User user = session.get(User.class, id); 
            return user;
        } catch(HibernateException ex) {
            throw new UserException("The user is not registered");
        } finally {
            try {
                session.close(); 
            } catch(HibernateException ex) {
                throw new UserException("Unable to close session");
            }
        }       
    }

    /**
     * Method used to get the User detail by using the userName 
     * @param userName
     * @return the user detail 
     * @throws UserException
     */
    public User getUserByName(String userName) throws UserException {
        User user = null;
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery("from User u where u.name = : userName");
            query.setParameter("userName", userName);
            user = (User) query.uniqueResult();
        } catch(HibernateException ex) {
            throw new UserException("The user is not registered");
        } finally {
            try {
                session.close();
            } catch(HibernateException ex) {
                throw new UserException("unable to close Session");
            }
        }
        return user;
    }
    
    /**
     * Method used to soft delete the User detail from the database  
     * @param userId
     * @return the number of affected
     * @throws UserException
     */
    public int deleteUser(int userId) throws UserException {
	    Session session = sessionFactory.openSession();
		Transaction transaction = null;
    	int noOfRowAffected = 0;
    	try {
            transaction = session.beginTransaction();
    		Query query = session.createQuery("update User u set u.status = :status where u.id = :userId");
            query.setBoolean("status", false);
    		query.setParameter("userId", userId);
    		noOfRowAffected = query.executeUpdate();
            transaction.commit();
        } catch(HibernateException ex) {
            if(null != transaction) {
                transaction.rollback();
            }
            throw new UserException("Unable to delete the given User");
        } finally {
            try {
                session.close(); 
            } catch(HibernateException e) {
                throw new UserException("Unable to close session");
            }
        }
        return noOfRowAffected;
    }
    
    /**
     * Method used to count the number of users in the database 
     * @return the number of Users
     * @throws UserException
     */
    public long countUser() throws UserException {
	    Session session = sessionFactory.openSession();
    	Transaction transaction = null;
    	long count = 0L;
    	try {
            transaction = session.beginTransaction();
    		Query query = session.createQuery("select count(u.id) from User u ");
            count = (Long) query.iterate().next();
        } catch(HibernateException ex) {
            throw new UserException("Unable to count User");
        } finally {
            try {
                session.close(); 
            } catch(HibernateException e) {
                throw new UserException("Unable to close session");
            }
        }
        return count;        
    }
}