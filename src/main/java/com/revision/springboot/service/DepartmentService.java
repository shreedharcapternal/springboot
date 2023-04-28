package com.revision.springboot.service;

import java.util.List;

import com.revision.springboot.entity.Department;
import com.revision.springboot.error.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Department fetchDepartmentById(Long departmentId);

	public void deleteDepartmentById(Long departmentId);

	public Department updateDepartment(Long departmentId, Department department) throws DepartmentNotFoundException;

	public Department fetchDepartmentByName(String departmentName);

	

}
