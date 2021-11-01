package com.mohamedtra.userManagement.api.test.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mohamedtra.userManagement.api.model.User;
import com.mohamedtra.userManagement.api.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataMongoTest
public class UserRepositoryTest {
	
	@Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        
    }

    @Test
    public void testWhenFindByLastName_thenReturnUser() {
        User result = userRepository.findByLastname("TRAORE");
        // assertEquals(result.getLastname(), "TRAORE", "Should return the same Last Name");
        assertThat(result).isEqualTo("TRAORE").as("Should return the same Last Name");
    }


}
