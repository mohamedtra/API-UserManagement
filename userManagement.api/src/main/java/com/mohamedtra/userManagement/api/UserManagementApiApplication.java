package com.mohamedtra.userManagement.api;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mohamedtra.userManagement.api.model.Address;
import com.mohamedtra.userManagement.api.model.User;
import com.mohamedtra.userManagement.api.repository.UserRepository;

/**
 * This Class the run  application
 * @author mohamed traore
 *
 */
@SpringBootApplication
public class UserManagementApiApplication implements CommandLineRunner {
	
	@Autowired
    private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(UserManagementApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/**
         * List of users to save in the database embedded
         */
        List<User> listUsers = new ArrayList<>();

        listUsers.add(new User("Mohamed","TRAORE", "test1@gmail.com", LocalDate.of(2000,2,12), new Address("5 rue du barri","paris","france",92000),"engineer"));
        listUsers.add(new User("Melissa","DURAND", "test2@gmail.com", LocalDate.of(2000,2,12),new Address("5 rue du barri","paris","france",92000), "engineer"));
        listUsers.add(new User("Thierno","DIALLO", "test3@gmail.com", LocalDate.of(2000,2,12),new Address("5 rue du barri","paris","france",92000), "engineer"));
        listUsers.add(new User("Jean","BOSCO", "test4@gmail.com", LocalDate.of(2001,2,12),new Address("5 rue du barri","paris","france",92000), "engineer"));
        listUsers.add(new User("Arsene","LUPIN", "test5@gmail.com", LocalDate.of(2000,2,12),new Address("5 rue du barri","paris","france",92000), "engineer"));
        listUsers.add(new User("Emmanuelle","MACRON", "test6@gmail.com", LocalDate.of(2002,2,12),new Address("5 rue du barri","paris","france",92000), "engineer"));
        listUsers.add(new User("Bernard","COUCHENAIRE", "test7@gmail.com", LocalDate.of(2000,2,12),new Address("5 rue du barri","paris","france",92000), "engineer"));
        listUsers.add(new User("Emmanuel","MACRON", "test8@gmail.com", LocalDate.of(2000,2,12),new Address("5 rue du barri","paris","france",92000), "engineer"));
        listUsers.add(new User("Lucien","MORETTI", "test9@gmail.com", LocalDate.of(2000,2,12),new Address("5 rue du barri","paris","france",92000), "engineer"));
        listUsers.add(new User("Nathalie","IANETTA", "test10@gmail.com", LocalDate.of(2000,2,12),new Address("5 rue du barri","paris","france",92000), "engineer"));

        userRepository.deleteAll();
        userRepository.insert(listUsers);
		
	}
}
