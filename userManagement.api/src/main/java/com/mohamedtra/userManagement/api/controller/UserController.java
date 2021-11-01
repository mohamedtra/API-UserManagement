package com.mohamedtra.userManagement.api.controller;


import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mohamedtra.userManagement.api.Constants.Constants;
import com.mohamedtra.userManagement.api.controller.exceptions.ApiException;
import com.mohamedtra.userManagement.api.controller.exceptions.ErrorResource;
import com.mohamedtra.userManagement.api.model.User;
import com.mohamedtra.userManagement.api.service.impl.UserServiceImpl;
import com.mohamedtra.userManagement.api.userUtil.UserUtil;
/**
 * UserController class to define and expose all endpoint
 * @author mohamed traore
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired 
	UserServiceImpl userServiceImpl;
	
	Logger logger = Logger.getLogger(UserController.class.getName());
	
	/**
	 * Method to displays the details of a registered user
	 * @param lastname, path variable to find
	 * @return User that match with lastname 
	 */
	@GetMapping("/display/{lastname}")
	public User getUserByLastNameInPath(@PathVariable(value = "lastname") String lastname) {
	
		long time = System.currentTimeMillis();
        logger.log(Level.INFO,"Starting GetUsersByLastName GET('/users/display/{lastname}')");
        lastname = lastname.toUpperCase();
        
        User result = userServiceImpl.getUserByLastNameInPath(lastname);
        if(result == null) {
        	throw new ApiException(new ErrorResource("error user not found", lastname, HttpStatus.OK));
        }
        
        time = System.currentTimeMillis() - time;
        logger.log(Level.INFO,"Ending GetUsersByLastName in GET('/users/display/{lastname}') "+ time + " ms");
        
        return result;
	}
	
	  /**
	   * Method to display the details of registered
	   * @param lastname, param request
	   * @return
	   */
	  @GetMapping("") 
	  public User getUserByLastName(@RequestParam(value = "lastname") String lastname) {
	  
		  long time = System.currentTimeMillis(); logger.log(Level.
		  INFO,"Starting GetUsersByLastName GET('/users/display?lastname=value)");
		  lastname = lastname.toUpperCase();
		  
		  User result = userServiceImpl.getUserByLastName(lastname); 
		  if(result == null) { 
			  throw new ApiException(new ErrorResource("error user not found", lastname,HttpStatus.OK)); 
		  }
		  
		  time = System.currentTimeMillis() - time; logger.log(Level.
		  INFO,"Ending GetUsersByLastName in GET('/users/display?lastname=value) "+ time + " ms");
		  
		  return result; 
	  }
	 
	
	/**
	 * Method to registre user 
	 * @param user
	 * @return a ResponseEntity or throw an error
	 */
	@PostMapping("")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		long time = System.currentTimeMillis();
        logger.log(Level.INFO,"Starting to POST('/users')");
        
        if(!user.getAddress().getCountry().equalsIgnoreCase(Constants.COUNTRY_AUTHORISED)){
            time = System.currentTimeMillis() - time;
            logger.log(Level.INFO,"Ending to  POST('/users') "+ time + " ms");
            throw new ApiException(new ErrorResource("Country not in France", user.getAddress().getCountry(), HttpStatus.OK));
            
        }
        
        if(!UserUtil.isMajor(user.getBirthdate())){
            time = System.currentTimeMillis() - time;
            logger.log(Level.INFO,"Ending to  POST('/users') "+ time + " ms");
            throw new ApiException(new ErrorResource("Your are not Adult, age lower than 18 ", user.getAddress().getCountry(), HttpStatus.OK));
        }
     
        user.setLastname(user.getLastname().toUpperCase());

        User userSaved = userServiceImpl.addUser(user);
        Map<String,Object> result = new HashMap<>();
        result.put("userId", userSaved.getId());
        result.put("status", HttpStatus.CREATED);
        result.put("result", "SUCCESS");

        time = System.currentTimeMillis() - time;
        logger.log(Level.INFO,"Ending to POST('/users') "+ time + " ms");
       
        return new ResponseEntity<>(result,HttpStatus.CREATED);
        
        
	}

}
