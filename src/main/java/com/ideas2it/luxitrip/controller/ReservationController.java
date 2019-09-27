package com.ideas2it.luxitrip.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Bus;
import com.ideas2it.luxitrip.model.Route;
import com.ideas2it.luxitrip.model.Schedule;
import com.ideas2it.luxitrip.model.Stop;
import com.ideas2it.luxitrip.service.ReservationService;
import com.ideas2it.luxitrip.service.RouteService;
import com.ideas2it.luxitrip.service.StopService;

@Controller
public class ReservationController {
    @Autowired
    StopService stopService;
    
    @Autowired
    ReservationService reservationService; 
    
    /**
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getSchedules")
    public ModelAndView displayBusByOriginAndDestination(HttpServletRequest request,
            HttpServletResponse response) {
        ModelAndView model = new ModelAndView("busListForUser");
        try {
            HttpSession session = request.getSession();
            Stop origin = (Stop) request.getParameter("source");
            Stop destination = (Stop) request.getParameter("destination");
            session.setAtrribute("source",source);
            session.setAtrribute("destination",destination);
            Set<Schedule> schedules = reservationService.getSchedules(origin,destination);
            for(Schedule schedule : schedules) {
                System.out.println("After");
                System.out.println(schedule.getBus());
                System.out.println("finish");
            }
            model.addObject("schedules",schedules);
        } catch(CustomException exception) {
            model = new ModelAndView("ErrorPage","error",exception);
        }
        return model;
    }
}
