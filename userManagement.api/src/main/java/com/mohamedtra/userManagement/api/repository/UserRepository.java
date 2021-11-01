package com.mohamedtra.userManagement.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mohamedtra.userManagement.api.model.User;

/**
 * Interface User repository 
 * @author mohamed
 *
 */
@Repository
public interface UserRepository extends MongoRepository<User, String>  {
	
	/**
	 * Method to find user by lastname
	 * @param lastname
	 * @return A user that match lastname in DB
	 */
	User findByLastname(String lastname);

}
