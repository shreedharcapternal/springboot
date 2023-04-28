package com.revision.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revision.springboot.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
	
	public Department findByDepartmentNameIgnoreCase(String departmentName);
}
