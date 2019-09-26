package com.ideas2it.luxitrip.service;

import java.util.Set;

import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Bus;
import com.ideas2it.luxitrip.model.Schedule;
import com.ideas2it.luxitrip.model.Stop;

public interface ReservationService {
    
    Set<Bus> getBusesByOriginAndDestination(Stop origin,Stop destination)
            throws CustomException;

    Set<Schedule> getSchedules(Stop origin,Stop destination) throws CustomException;
}
