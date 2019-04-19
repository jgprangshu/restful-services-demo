package com.capgemini.restfulwithjunit;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.restfulwithjunit.controller.HelloController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestfulWithJunitApplicationTests {

	private MockMvc mockMvc;
	
	@InjectMocks
	private HelloController hellocontroller;
	
	@Before
	public void setUp() throws Exception{
		//instance of mockmvc
		mockMvc = MockMvcBuilders.standaloneSetup(hellocontroller).build();
	}
	
	
	@Test
	public void testHelloWorld() throws Exception{
		
		mockMvc.perform(
				MockMvcRequestBuilders.get("/hello")
				)
					.andDo(print()).andExpect(MockMvcResultMatchers.status().isOk())
					.andExpect(MockMvcResultMatchers.content().string("Hello!"));
		
	}
	

}
