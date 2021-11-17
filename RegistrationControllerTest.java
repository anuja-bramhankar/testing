package com.psl.training;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.psl.training.controllers.RegistrationController;
import com.psl.training.repository.UserRepository;
import com.psl.training.service.UserService;

@SpringBootTest
@WebAppConfiguration
@ContextConfiguration

public class RegistrationControllerTest {
	
	@Autowired
	UserService serviceU;

	@Autowired
	UserRepository repositoryU;
	
	@Autowired
	RegistrationController Rcontroller;
	
	
	MockMvc rmvc;
	
	
	 user.setuserName("Anuja");
	 user.setpassword("123");
	 user.setmobileNumber("9168432957");
	 user.setDOB("02-06-2000");
	 user.setemail("anuja_bramhankar@persistent.com");
	
	@Test
	public void insertUser() throws Exception{
		 rmvc.perform( MockMvcRequestBuilders
		            .post("/reg")
		            .accept(MediaType.APPLICATION_JSON))
		            .andDo(print())
		            .andExpect(status().isOk())
		            .andExpect(MockMvcResultMatchers.jsonPath("$.userNmae").value("Anuja"))
		            .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("123"))
		            .andExpect(MockMvcResultMatchers.jsonPath("$.mobileNumber").value("9168432957"))
		            .andExpect(MockMvcResultMatchers.jsonPath("$.DOB").value("02-06-2000"))
		            .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("anuja_bramhankar@persistent.com"));

		}

}
