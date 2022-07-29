package com.rest.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.rest.controller.GreetingController;

@SpringBootTest
class HelloRestApiApplicationTests {
	private MockMvc mockMvc;

	@InjectMocks
	private GreetingController greeting;

	@BeforeEach
	void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(greeting).build();
	}

	@Test
	void testGreetingController() throws Exception {
		mockMvc.perform(get("/hello"))
				.andExpect(status().isOk())
				.andExpect(content().string("Hello World!"));
	}

	@Test
	void testGreetingControllerRest() throws Exception {
		mockMvc.perform(get("/hello/json?name=hein").accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", Matchers.is(1)))
				.andExpect(jsonPath("$.greetings", Matchers.is("Hello, hein!")));
	}
}
