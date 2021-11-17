package com.psl.training;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.psl.training.controllers.RegistrationController;
import com.psl.training.repository.UserRepository;
import com.psl.training.service.UserService;


@SpringBootTest
@WebAppConfiguration
@ContextConfiguration

public class LoginControllerTest {
	
	@Autowired
	UserService serviceU;

	@Autowired
	UserRepository repositoryU;
	
	@Autowired
	RegistrationController Rcontroller;
	
	
	MockMvc lmvc;
	
	 user.setuserName("Anuja");
	 user.setpassword("123");
	
	@Test
	public void insertUser() throws Exception{
		 lmvc.perform( MockMvcRequestBuilders
		            .post("/login")
		            .accept(MediaType.APPLICATION_JSON))
		            .andDo(print())
		            .andExpect(status().isOk())
		            .andExpect(MockMvcResultMatchers.jsonPath("$.userNmae").value("Anuja"))
		            .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("123"));

		}


}
