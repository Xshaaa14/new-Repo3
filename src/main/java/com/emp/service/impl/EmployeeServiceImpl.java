package com.emp.service.impl;

import com.emp.PostDto;
import com.emp.entity.Employee;
import com.emp.exception.ResourceNotFoundException;
import com.emp.payload.EmpDto;
import com.emp.repository.EmployeeRepository;
import com.emp.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepo;

    public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public EmpDto createEmp(EmpDto empDto) {

        Employee employee = new Employee();
        employee.setName(empDto.getName());
        employee.setCity(empDto.getCity());
        employee.setState(empDto.getState());

        Employee savedEmp = employeeRepo.save(employee);

        EmpDto dto = new EmpDto();
        dto.setId(savedEmp.getId());
        dto.setName(savedEmp.getName());
        dto.setCity(savedEmp.getCity());
        dto.setState(savedEmp.getState());


        return dto;

    }

    @Override
    public void deleteEmp(long id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Record not found with id +id")

        );

        employeeRepo.deleteById(id);
    }

    @Override
    public List<EmpDto> getAllEmp() {
        List<Employee> emp = employeeRepo.findAll();
        List<EmpDto> dtos = emp.stream().map(e -> mapToDto(e)).collect(Collectors.toList());

        return dtos;
    }

   EmpDto mapToDto(Employee employee) {
       EmpDto dto = new EmpDto();
       dto.setId(employee.getId());
       dto.setName(employee.getName());
       dto.setCity(employee.getCity());
       dto.setState(employee.getState());

       return dto;

   }
}