package com.mohamedtra.userManagement.api.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mohamedtra.userManagement.api.model.Address;
import com.mohamedtra.userManagement.api.model.User;
import com.mohamedtra.userManagement.api.repository.UserRepository;
import com.mohamedtra.userManagement.api.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

	@Autowired
	private WebApplicationContext ctx;

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	private MockMvc restUserMockMvc;

	@BeforeEach
	public void setup() {
		this.restUserMockMvc = MockMvcBuilders.webAppContextSetup(ctx).defaultRequest(get("/*"))
				.defaultRequest(post("/*")).build();
	}

	@Test
	public void getUsersByLastName() throws Exception {
		restUserMockMvc.perform(MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void getUsersByLastNameInPath() throws Exception {
		restUserMockMvc
				.perform(MockMvcRequestBuilders.get("/users/search/{lastname}", "TRAORE")
						.accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.lastname").value("TRAORE"));
	}

	@Test
	public void addUser() throws Exception {
		User user = new User("Jean", "BOSCO", "jeanbo@gmail.com", LocalDate.of(2000, 2, 12),
				new Address("34 rue de la paix", "paris", "Cannes", 06400), "engineer");
		restUserMockMvc.perform(MockMvcRequestBuilders.post("/users")
                .content(asJsonString(user))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
