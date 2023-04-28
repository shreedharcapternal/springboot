package com.revision.springboot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revision.springboot.entity.Department;
import com.revision.springboot.repository.DepartmentRepository;

@SpringBootTest
public class DepartmentServiceTest {
	
	@Autowired
	private DepartmentService departmentService;
	
	@MockBean
	private DepartmentRepository departmentRepository;
	
	@BeforeEach
	void setUp() {
		Department department = new Department(1L,"CS","MIT","404");
		Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("CS")).thenReturn(department);
	}
	
	@Test
	public void whenValidDepartmentName_thenDepartmentShouldFound() {
		String departmentName = "CS";
		Department found = departmentService.fetchDepartmentByName(departmentName);
		
		assertEquals(departmentName,found.getDepartmentName());
	}
}
