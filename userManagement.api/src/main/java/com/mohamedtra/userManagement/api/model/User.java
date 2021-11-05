package com.mohamedtra.userManagement.api.model;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@NotBlank@Size(message = "firstname is mandatory")
    private String firstname;
	@NotBlank@Size(message = "lastname is mandatory")
    private String lastname;
	@NotBlank@Email(message = "It should be an email")
    private String email;
	@NotBlank(message = "Birth Date is mandatory")
    private LocalDate birthdate;
	@NotNull(message = "Address is mandatory")
    private Address address;
	private String profession ;
	public User() {
	}
	
	/**
	 * Constructor of a user with all parameter
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param birthdate
	 * @param address
	 * @param profession
	 */
	public User(String firstname, String lastname, String email, LocalDate birthdate, Address address, String profession) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.birthdate = birthdate;
		this.address = address;
		this.profession = profession;
	}
}




