package com.ideas2it.luxitrip.dao;

import java.util.List;

import com.ideas2it.luxitrip.exception.UserException;
import com.ideas2it.luxitrip.model.Fare;

public interface FareDao {

	/**
	 * Method used to insert the fare and its details into the database
	 * @param fare
	 * @throws UserException
	 */
    void insertFare(Fare fare)throws UserException;
	
    /**
	 * Method used to update the detail of fare in the database 
	 * @param fare
	 * @throws UserException
	 */
    void updateFare(Fare fare)throws UserException;
    
    /**
	 * Method used to delete the given fare from the table 
	 * @param fareId
	 * @return the number of affected in table in integer 
	 * @throws UserException
	 */
	int deleteFare(int fareId) throws UserException;
	
	/**
	 * Method to get the List of fares in the form of list 
	 * @return the fare details in list
	 * @throws UserException
	 */
	List<Fare> getFares() throws UserException;
	
	/**
     * Method used to get the fare detail by using the specific fare id
     * @param id
     * @return the fare detail
     * @throws UserException
     */
	Fare getFareById(int id) throws UserException;
}
