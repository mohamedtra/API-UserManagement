package com.mohamedtra.userManagement.api.test.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mohamedtra.userManagement.api.model.Address;
import com.mohamedtra.userManagement.api.model.User;
import com.mohamedtra.userManagement.api.service.impl.UserServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {
	
	 	@Autowired
	    private UserServiceImpl userServiceImpl;

	    @BeforeEach
	    public void setUp() {
	    }

	    @Test
	    public void addUser() {
	        User user = new User("Melissa","DURAND", "melissadu@gmail.com", LocalDate.of(2000,2,12), new Address("5 rue barri","paris","france",75000));
	        User userSaved = userServiceImpl.addUser(user);
	        assertThat(userSaved).isEqualTo("DURAND").as("Should return the same Last Name");
	        //assertEquals(userSaved.getLastname(), "TATA", "Should return the same Last Name");
	    }
}
