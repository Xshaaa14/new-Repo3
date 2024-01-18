package com.emp.controller;

import com.emp.PostDto;
import com.emp.payload.EmpDto;
import com.emp.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empp")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<?> createEmp(@Valid @RequestBody EmpDto empDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        EmpDto dto = employeeService.createEmp(empDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmp(@PathVariable long id){
        employeeService.deleteEmp(id);
        return new ResponseEntity<>("Emp is deleted!!", HttpStatus.OK);
    }

    //http://localhost:8080/api/empp?pageNo=0&pageSize=5
    @GetMapping
    public ResponseEntity<List<EmpDto>>getAllEmp(
           @RequestParam(name="pageNo" )


    ){
        List<EmpDto> empDtos = employeeService.getAllEmp();
        return new ResponseEntity<>(empDtos, HttpStatus.OK);

    }



}
