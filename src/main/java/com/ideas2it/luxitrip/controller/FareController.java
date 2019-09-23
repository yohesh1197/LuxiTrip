package com.ideas2it.luxitrip.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;    
import org.springframework.web.bind.annotation.ModelAttribute;   
import org.springframework.web.bind.annotation.RequestMapping;

import com.ideas2it.luxitrip.exception.CustomException;
import com.ideas2it.luxitrip.model.Fare;
import com.ideas2it.luxitrip.service.FareService;


@Controller
public class FareController {
    
	@Autowired
	private FareService fareService;
	
	/**
	 * Method used to register the details of Fare 
	 * @param request
	 * @param response
	 * @return the confirmation message to user
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/createFare")
	public ModelAndView createFare(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	    Fare fare = new Fare();
	    try {
	    	fareService.createFare(fare);
	    	return new ModelAndView("Message", "message", "Fare Added Successfully" );
	    } catch(CustomException ex) {
	    	return new ModelAndView("Message", "message", ex);
	    }
	}
	
	/**
	 * Method used to update the detail of fare from existing fare
	 * @return the confirmation message to the user
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/updateFare")
	public ModelAndView updateFare(@ModelAttribute("fare")Fare fare) throws ServletException, IOException {
		try {
			fareService.updateFare(fare);
			return new ModelAndView("Message", "message", "Fare Updates successfully");
		} catch(CustomException ex) {
			return new ModelAndView("Message", "message", ex);
		}
	}
	/**
	 * Method used to display the list of fares from the database
	 * @return the list of fares 
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/displayFares")
	public ModelAndView displayFares() throws ServletException, IOException {
		try {
		    List<Fare> fares = fareService.retrieveFares();
		    return new ModelAndView("userPage", "fares", fares);
		} catch (CustomException ex) {
			return new ModelAndView("error", "error", ex);
		}
	}
	
	/**
	 * Method used to display the fare and its details by using the fareId
	 * @param request
	 * @param response
	 * @return fare detail
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/displayToUpdateFare")
	public ModelAndView getFareById(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
        int fareId = (Integer.parseInt(request.getParameter("fareId")));
        try {
        	Fare fare = fareService.retrieveFareById(fareId);
        	return new ModelAndView("updateUserForm", "fare", fare);
        } catch(CustomException ex) {
        	return new ModelAndView("error", "error", ex);
        }
	}
	
	/**
	 * Method used to Delete the fare by using the fare id
	 * @param request
	 * @param response
	 * @return the confirmation to the user
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/deleteFare")
	public ModelAndView deleteFare(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int fareId = (Integer.parseInt(request.getParameter("fareId")));
	    try {
	    	fareService.deleteFare(fareId);
	    	return new ModelAndView("Message", "message", "Fare deleted Successfully");
	    } catch(CustomException ex) {
	    	return new ModelAndView("error", "error", ex);
	    }
	}
}
