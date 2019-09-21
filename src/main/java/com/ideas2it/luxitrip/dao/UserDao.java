package com.ideas2it.luxitrip.dao;

import java.util.List;

import com.ideas2it.luxitrip.exception.UserException;
import com.ideas2it.luxitrip.model.User;

public interface UserDao {
	
	/**
	 * Method Used to insert the User detail from the User into the Database 
	 * @param user
	 * @throws UserException
	 */
	void insertUser(User user) throws UserException;
	
	/**
	 * Method used to soft delete the User from the database by using the userId 
	 * @param user
	 * @return the numberOfRowsAffected count 
	 * @throws UserException
	 */
    int deleteUser(int userId) throws UserException;
	
	/**
	 * Method used to update the user detail from the database by using the detail 
	 * from the user
	 * @param user
	 * @throws UserException
	 */
	void updateUser(User user) throws UserException;
	
	/** 
	 * Method used to get the List of user from the database
	 * @return the list of users
	 * @throws UserException
	 */
    List<User> getUsers() throws UserException;
    
    /**
     * Method used to get the User object in the specific userId
     * @param userId
     * @return the user object
     * @throws UserException
     */
    User getUserById(int userId) throws UserException;
 
    /**
     * Method used to count the number of Users in the database 
     * @return the users count in long
     * @throws UserException
     */
    long countUser() throws UserException;

}