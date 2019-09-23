package com.ideas2it.luxitrip.service;

import java.util.List;

import com.ideas2it.luxitrip.exception.UserException;
import com.ideas2it.luxitrip.model.Fare;

public interface FareService {

	/**
     * Method used to create the Fare details into the database 
     * @param fare
     * @throws UserException
     */
    public void createFare(Fare fare) throws UserException;
    
    /**
     * Method used to update the value of existing fare values 
     * @param fare updating values 
     * @throw UserException
     */
    public void updateFare(Fare fare) throws UserException;
    
    /**
     * Method used to delete the value of fare by using the id 
     * @param fareId
     * @throws UserException
     */
    public void deleteFare(int fareId) throws UserException;
    
    /**
     * Method used to retrieve the list of fare objects into the database
     * @return the list of fares
     * @throws UserException
     */
    public List<Fare> retrieveFares() throws UserException;
    
    /**
     * Method used to retrieve the fare and its details by using the fareId
     * @param id
     * @return
     * @throws UserException
     */
    public Fare retrieveFareById(int id) throws UserException;
}
