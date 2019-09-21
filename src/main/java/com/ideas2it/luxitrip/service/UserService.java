package com.ideas2it.luxitrip.service;

import java.util.List;

import com.ideas2it.luxitrip.exception.UserException;
import com.ideas2it.luxitrip.model.User;

public interface UserService {
	
	/**
	 * Method used to create the User with the User detail 
	 * @param User it get the user detail to store
	 * @throws UserException
	 */
    void createUser(User user) throws UserException;
    
    /**
     * Method used to delete the user in the given UserId 
     * @param userId
     * @throws UserException
     */
	void deleteUser(int userId) throws UserException;
	
	/**
	 * Method used to update the userDetail from the Existing userdetail in the given userId
	 * @param user
	 * @throws UserException
	 */
	void updateUser(User user) throws UserException;
	
	/**
	 * Method used to retrieve the list of users in the database
	 * @return the list of users
	 * @throws UserException
	 */
	List<User> retrieveUsers() throws UserException;
	
	/**
	 * Method used to retrieve the user and its details in the given Specific UserId
	 * @param userId
	 * @return the user and its details
	 * @throws UserException
	 */
	User retrieveUserById(int userId) throws UserException;

}
