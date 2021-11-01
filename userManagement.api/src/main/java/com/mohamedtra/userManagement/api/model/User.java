package com.mohamedtra.userManagement.api.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * Class that represent a User
 * @author mohamed traore
 *
 */

@Data
@Document
public class User {
	
	@Id
    private String id;
	
    private String firstname;
    
    private String lastname;
    
    private String email;
    
    private LocalDate birthdate;
    
    private Address address;

	public User() {
	}
	
	/**
	 * Constructor of a user with all parameter
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param birthdate
	 * @param address
	 */
	public User(String firstname, String lastname, String email, LocalDate birthdate, Address address) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.birthdate = birthdate;
		this.address = address;
	}
}




