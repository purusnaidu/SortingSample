package com.sorting;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class TestSortingServices extends ApplicationTests {

	@Autowired
	private WebApplicationContext webAppCtx;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webAppCtx).build();
	}

	/**
	 *  Basic testing, just checking if the record in index 0 is not having any error 
	 */
	@Test
	public void basicUnitTest() {
		try {
			mockMvc.perform(get("/sortedNumbers?&unsortedNumbers=1,2,")).andExpect(status().isOk())
					.andExpect(content().contentType("application/json;charset=UTF-8"))
					.andExpect(jsonPath("$[0].error").isEmpty());
		} catch (Exception e) {
			Logger.getLogger(this.getClass().getSimpleName()).log(Level.SEVERE, e.getMessage());
		}
		}
}