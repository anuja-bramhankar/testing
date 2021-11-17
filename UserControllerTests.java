
package com.psl.training;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.psl.training.controllers.UserController;
import com.psl.training.repository.UserRepository;
import com.psl.training.service.UserService;
import com.psl.training.entity.*;

@SpringBootTest
@WebAppConfiguration
@ContextConfiguration
public class UserControllerTests {
	@Autowired
	UserService serviceU;

	@Autowired
	UserRepository repositoryU;
	
	@Autowired
	UserController controller;
	
	MockMvc mockmvc;
	@BeforeAll
	public void setup() {
		this.mockmvc=MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void testUserDetails() throws Exception{
		mockmvc.perform(get("/user/{1}").accept(MediaType.APPLICATION_JSON))
				.andExcept(MockMvcResultMachers.status().isok())
		        .andExcept(jsonPath("$.userID").value("1")); 
			
	}
	
	@Test
	public void testUserUpdate() throws Exception{
		/*mockmvc.perform((put("/user/{1}").contentType(MediaType.APPLICATION_JSON))
				.andExcept(status().isOk())
				.andExcept(jsonPath("$.userid",Matchers.equalTo(2)));
				     given(service.updateUser(user.getId(), user)).willReturn(user);*/
		User user=new User();
		user.setUserID(2);
		given(serviceU.updateUser(user)).willReturn(user);
		ObjectMapper mapper = new ObjectMapper();

		mockmvc.perform(put("/user/" + user.getuser().toString())
		      .contentType(MediaType.APPLICATION_JSON))
		      .content(mapper.writeValueAsString(user))
		      .andExpect(status().isAccepted())
		      .andExpect(jsonPath("", is(user.getuser())));


}
