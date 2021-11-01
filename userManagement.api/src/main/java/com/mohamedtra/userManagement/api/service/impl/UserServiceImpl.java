package com.mohamedtra.userManagement.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohamedtra.userManagement.api.model.User;
import com.mohamedtra.userManagement.api.repository.UserRepository;
import com.mohamedtra.userManagement.api.service.UserService;

/**
 * Class to implement user service and Inject User Repository to write body of method
 * @author mohamed traore
 *
 */
@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Add user in DB
	 * @param user, user to insert
	 * @return the user inserted
	 */
	@Override
	public User addUser(User user) {
		return userRepository.insert(user);
	}
	/**
	 * Get user by lastname
	 * @param lastname, fied to find
	 * @return User Object
	 */
	@Override
	public User getUserByLastNameInPath(String lastname) {
		
		return userRepository.findByLastname(lastname);
	}
	/**
	 * Get user by lastname
	 * @param lastname, fild find
	 */
	@Override
	public User getUserByLastName(String lastname) {
		
		return userRepository.findByLastname(lastname);
	}
	
	
}
