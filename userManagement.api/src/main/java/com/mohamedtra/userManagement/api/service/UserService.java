package com.mohamedtra.userManagement.api.service;

import com.mohamedtra.userManagement.api.model.User;

/**
 * Interface user service
 * @author mohamed traore
 *
 */
public interface UserService {
	
	/**
	 * Registre user in DB
	 * @param user to insert 
	 * @return User Object 
	 */
	User addUser(User user);
	/**
	 * Get the variable value in path url
	 * @param lastname, variable path to find
	 * @return A user that match lastname in DB
	 */
	User getUserByLastNameInPath(String lastname);
	
	/**
	 * Get the param value in url
	 * @param lastname, request param to find
	 * @return A user that match lastname in DB
	 */
	User getUserByLastName(String lastname);
	
	
	

}
