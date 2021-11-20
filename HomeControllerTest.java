package com.psl.training.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.psl.training.entity.AppointmentEntry;
import com.psl.training.service.AppointmentCalendarService;
import com.psl.training.service.AppointmentEntryService;
import com.psl.training.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {HomeController.class})
//@SpringBootTest(properties = "spring.main.lazy-initialization=true",classes= {com.psl.training.config.GabsApplication.class})
@AutoConfigureMockMvc
public class HomeControllerTest {
	
	@MockBean
	AppointmentEntryService serviceAE;

	@MockBean
	UserService serviceU;

	@Autowired
	private MockMvc mockmvc;
	
	
	@Test
	public void  getAppointmentEntryByOwner() throws Exception{
		List<AppointmentEntry> l =null ;
		when(serviceAE.getAppointmentEntryByOwner(1)).thenReturn(l);
		
		MockHttpServletRequestBuilder req=MockMvcRequestBuilders.get("/home/1");
		ResultActions perform=mockmvc.perform(req).andDo(print());
		
		MvcResult mvcResult=perform.andReturn();
		MockHttpServletResponse response=mvcResult.getResponse();
		int status=response.getStatus();
		assertEquals(200,status);
		
	}
		
	}


