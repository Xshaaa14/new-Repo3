package com.emp.service;

import com.emp.PostDto;
import com.emp.payload.EmpDto;

import java.util.List;

public interface EmployeeService {

  public EmpDto createEmp(EmpDto empDto);

    void deleteEmp(long id);


  List<EmpDto> getAllEmp();
}
