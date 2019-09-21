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

import com.ideas2it.luxitrip.service.impl.UserServiceImpl;
import com.ideas2it.luxitrip.model.User;
import com.ideas2it.luxitrip.exception.UserException;

@Controller
public class UserController {
	@Autowired
	private UserServiceImpl userService;
	
	/**
	 * Method used to create the user object to store the values of the user
	 * @return the user object
	 * @throws ServletException
	 * @throws IOException
	 */
	public ModelAndView createUser() throws ServletException, IOException {
		User user = new User();
		return new ModelAndView("", "user", user);
	}
	   
	/**
	 * Method used to register the user and its detail in the database
	 * @param user
	 * @return the confirmation to the User 
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("")
	public ModelAndView registerUser(@ModelAttribute("user")User user) 
			                        throws ServletException, IOException {
		try {
		    userService.createUser(user);
		    return new ModelAndView("", "message", "User Added Successfully");
		} catch (UserException ex) {
			return new ModelAndView("error",  "error", ex);
		}
    }
	
	/**
	 *  Method used to display the list of users in the database 
	 * @return the list of users
	 * @throws ServletException
	 * @throws IOException
	 */
	public ModelAndView displayUsers() throws ServletException, IOException {
	    try {
		    List<User> users = userService.retrieveUsers();
		    return new ModelAndView("", "users", users);
		} catch (UserException ex) {
			return new ModelAndView("error", "error", ex);
		}
	}
	
	/**
	 * Method used to get the User from the database by using the userId
	 * @param request
	 * @param response
	 * @return the userObject to the requested page
	 * @throws ServletException
	 * @throws IOException
	 */
	public ModelAndView getUser(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
        int userId = (Integer.parseInt(request.getParameter("id")));
        try {
        	User user = userService.retrieveUserById(userId);
        	return new ModelAndView("", "user", user);
        } catch(UserException ex) {
        	return new ModelAndView("error", "error", ex);
        }
	}
	
	/**
	 * Method used to update the user detail from the existing user detail
	 * @param user - it get the updated user detail
	 * @return the confirmation to the user
	 * @throws ServletException
	 * @throws IOException
	 */
	public ModelAndView updateUser(@ModelAttribute("user")User user) 
			throws ServletException, IOException {
		try {
	 	    userService.updateUser(user);
		    return new ModelAndView("", "message", "User updated successfully");
	    } catch(UserException ex) {
	    	return new ModelAndView("error", "error", ex);
	    }
	}
	
	/**
	 * Method used to delete the User from the database by using the UserId 
	 * given from the User
	 * @return the confirmation to the user
	 * @throws ServletException
	 * @throws IOException
	 */
	public ModelAndView deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	    int userId = (Integer.parseInt(request.getParameter("id")));
	    try {
	    	userService.deleteUser(userId);
	    	return new ModelAndView("", "message", "User deleted Successfully");
	    } catch(UserException ex) {
	    	return new ModelAndView("error", "error", ex);
	    }
	}

}
