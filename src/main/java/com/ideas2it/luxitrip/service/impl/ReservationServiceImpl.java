package com.ideas2it.luxitrip.service.impl;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.luxitrip.dao.ReservationDao;
import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Bus;
import com.ideas2it.luxitrip.model.Midway;
import com.ideas2it.luxitrip.model.Route;
import com.ideas2it.luxitrip.model.Schedule;
import com.ideas2it.luxitrip.model.Stop;
import com.ideas2it.luxitrip.service.ReservationService;
import com.ideas2it.luxitrip.service.RouteService;

@Service
public class ReservationServiceImpl implements ReservationService{
    
    @Autowired
    ReservationDao reservationDao;
    
    @Autowired
    RouteService routeService;
    
    public Set<Bus> getBusesByOriginAndDestination(Stop origin,Stop destination)
            throws CustomException{
        Collection<Bus> originBuses = reservationDao.getBusesByOrigin(origin);
        Collection<Bus> destinationBuses = reservationDao.getBusesByDestination(destination);
        originBuses.addAll(destinationBuses);
        return (Set<Bus>) originBuses;
    }
    
    public Set<Schedule> getSchedules(Stop origin,Stop destination) 
            throws CustomException{
        Set<Schedule> schedules = new HashSet<>();
        List<Route> routes = routeService.retrieveAllRoutes();
        for (Route route : routes) {
            for (Schedule schedule : route.getSchedules()) {
                for (Midway midway : schedule.getMidways()) {
                    if(origin.equals(midway.getStop()) 
                            || destination.equals(midway.getStop())) {
                        Date originDate = new Date();
                        if (origin.equals(midway.getStop())) {
                            System.out.println(origin);
                            originDate = midway.getTime();
                        }
                        if (originDate.compareTo(midway.getTime()) < 0) {
                            schedules.add(schedule);
                        }
                    }
                }
            }
        }
        return schedules;
    }
}