package com.revision.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revision.springboot.entity.Department;
import com.revision.springboot.error.DepartmentNotFoundException;
import com.revision.springboot.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchDepartmentById(Long departmentId) {
		return departmentRepository.findById(departmentId).get();
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		departmentRepository.deleteById(departmentId);
		
	}

	@Override
	public Department updateDepartment(Long departmentId, Department department) throws DepartmentNotFoundException {
		Optional<Department> getdep = departmentRepository.findById(departmentId);
		if(!getdep.isPresent()) {
			throw new DepartmentNotFoundException("Department Not Found");
		}
		Department obj = getdep.get();
		obj.setDepartmentName(department.getDepartmentName());
		obj.setDepartmentAddress(department.getDepartmentAddress());
		obj.setDepartmentCode(department.getDepartmentCode());
		departmentRepository.save(obj);
		return obj;
	}

	@Override
	public Department fetchDepartmentByName(String departmentName) {
		return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
	}
	
}
