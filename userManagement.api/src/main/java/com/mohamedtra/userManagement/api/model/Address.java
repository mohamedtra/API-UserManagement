package com.mohamedtra.userManagement.api.model;

import lombok.Data;

/**
 * Class that represent a format of address
 * @author mohamed traore
 *
 */

@Data
public class Address{
	
	private String street;
	  
	private String city;
	  
	private String country;
	  
	private int code;
	
	/**
	 * Constructor with all parameter
	 * @param street
	 * @param city
	 * @param country
	 * @param code
	 */
	public Address(String street, String city, String country, int code) {
		this.street = street;
		this.city = city;
		this.country = country;
		this.code = code;
	}

	public Address() {
		
	}
	
	/**
	 * Method to formatted Address
	 * @return String Address
	 */
	@Override 
	public String toString() { 
		return 
				"{" + 
				"street='" + street + '\'' + 
				", city='" + city + '\'' + 
				", country='" + country + '\'' + 
				", code=" + code + '}'; 
	}
	 
}




