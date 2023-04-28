package com.revision.springboot.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import com.revision.springboot.entity.Department;
import com.revision.springboot.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DepartmentService departmentService;
	
	
	private Department department;
	
	@BeforeEach
	void setUp() {
		department = new Department(1L,"CS","MIT","404");
	}
	
	@Test
	void saveDepartment() throws Exception {
		Department inputdept = new Department(1L,"CS","MIT","404");
		
		Mockito.when(departmentService.saveDepartment(inputdept)).thenReturn(department);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/departments")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "    \"departmentName\": \"Mech\",\r\n"
						+ "    \"departmentAddress\": \"MIT\",\r\n"
						+ "    \"departmentCode\": \"404\"\r\n"
						+ "}")).andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
}
