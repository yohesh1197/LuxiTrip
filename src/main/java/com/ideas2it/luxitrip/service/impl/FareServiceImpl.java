package com.ideas2it.luxitrip.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import com.ideas2it.luxitrip.dao.FareDao;
import com.ideas2it.luxitrip.exception.UserException;
import com.ideas2it.luxitrip.model.Fare;
import com.ideas2it.luxitrip.service.FareService;

@Service
public class FareServiceImpl implements FareService {
	
	@Autowired
	private FareDao fareDao;
	
    /**
     * Method used to create the Fare details into the database 
     * @param fare
     * @throws UserException
     */
    public void createFare(Fare fare) throws UserException {
        fareDao.insertFare(fare);	
    }
    
    /**
     * Method used to update the value of existing fare values 
     * @param fare updating values 
     * @throw UserException
     */
    public void updateFare(Fare fare) throws UserException {
    	fareDao.updateFare(fare);
    }
    
    /**
     * Method used to delete the value of fare by using the id 
     * @param fareId
     * @throws UserException
     */
    public void deleteFare(int fareId) throws UserException {
    	if(0 == fareDao.deleteFare(fareId)) {
    		throw new UserException("Unable to delete the Fare details ");
    	}
    }
    /**
     * Method used to retrieve the list of fare objects into the database
     * @return the list of fares
     * @throws UserException
     */
    public List<Fare> retrieveFares() throws UserException {
    	return fareDao.getFares();
    }
    
    /**
     * Method used to retrieve the fare and its details by using the fareId
     * @param id
     * @return
     * @throws UserException
     */
    public Fare retrieveFareById(int id) throws UserException {
    	return fareDao.getFareById(id);
    }
    
}
