package com.ideas2it.luxitrip.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ideas2it.luxitrip.service.impl.BusServiceImpl;
import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Bus;
import com.ideas2it.luxitrip.model.Seat;

@Controller
public class BusController {
@Autowired
    private BusServiceImpl busService = new BusServiceImpl();

    @RequestMapping("/registerBus")
    public ModelAndView registerBus(HttpServletRequest request, 
            HttpServletResponse response, Bus bus)
            throws IOException, ServletException {
        try {
            int capacity = Integer.parseInt(request.getParameter("capacity"));
            //int count = 1;
            bus.setBusNumber(request.getParameter("busNumber"));
            bus.setCapacity(capacity);
            bus.setOperator(request.getParameter("operator"));
            bus.setType(request.getParameter("type"));
            bus.setStatus(true);
            /*do {
                Seat seat = new Seat();
                seat.setNumber(request.getParameter("number"+count) );
                seat.setType(request.getParameter("type"+count) );
                seat.setAvailability(true);  
                busService.addSeat(bus,seat);
            } while (capacity != count++);*/
            busService.createBus(bus);
            return displayAllBuses(request,response);
        } catch (CustomException exception) {
            return (new ModelAndView("ErrorPage","error",exception));
        }
    }
    
    @RequestMapping("/fetchBus")
    public ModelAndView fetchBus(HttpServletRequest request, 
            HttpServletResponse response) throws IOException, ServletException {
        ModelAndView model = new ModelAndView("admin");
        try {
            Bus bus = 
                busService.retrieveBusById(Integer.parseInt(request.getParameter("id")));
            HttpSession session = request.getSession();
            session.setAttribute("bus", bus);  
        } catch (CustomException exception) {
            model = new ModelAndView("ErrorPage","error",exception);
        }
        return model;
    }
        
    /**
     * Gets the list of buses from server and forwards the request, response
     * @param request contains the list of buses data in 
     */
    @RequestMapping("/displayAllBuses")
    public ModelAndView displayAllBuses(HttpServletRequest request, 
            HttpServletResponse response) throws IOException, ServletException {
        ModelAndView model = new ModelAndView("adminpage");
        try {
            List<Bus> buses = busService.retrieveAllBuses();
            model.addObject("buses", buses);
        } catch (CustomException exception) {
            model = new ModelAndView("ErrorPage","error",exception);
        }
        return model;
    }
    
    /**
     * Updates the bus details in the buses list to the particular
     * Bus object
     */
    @RequestMapping("/updateBus")
    public ModelAndView updateBus(HttpServletRequest request, 
            HttpServletResponse response)
            throws IOException, ServletException {
        try {
            HttpSession session = request.getSession(false);
            Bus bus = (Bus) session.getAttribute("bus");
            bus.setBusNumber(request.getParameter("busNumber"));
            bus.setCapacity(Integer.parseInt(request.getParameter("capacity")));
            bus.setOperator(request.getParameter("operator"));
            bus.setType(request.getParameter("type"));
            bus.setStatus(true);
            busService.updateBus(bus);
            return displayAllBuses(request,response);
        } catch(CustomException exception) {
            return (new ModelAndView("ErrorPage","error",exception));
        }
    }
    
    /**
     * Soft deletes the Bus from the list of buses 
     * by geting the object from the entered bus id
     */
    @RequestMapping("/deleteBus")
    public ModelAndView deleteBus(HttpServletRequest request, 
            HttpServletResponse response) throws IOException, ServletException {
        try {
            Bus bus = 
                busService.retrieveBusById(Integer.parseInt(request.getParameter("id")));
            bus.setStatus(false);
            busService.deleteBus(bus);
            return displayAllBuses(request,response);
        } catch(CustomException exception) {
            return (new ModelAndView("ErrorPage","error",exception));
        }
    }
}
