package com.ideas2it.luxitrip.dao;

import java.util.List;

import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Bus;
import com.ideas2it.luxitrip.model.Stop;

public interface ReservationDao {
    List<Bus> getBusesByOrigin(Stop origin) 
            throws CustomException;
    
    List<Bus> getBusesByDestination(Stop destination) 
            throws CustomException;
}
