package com.example.demo.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {


    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getStudents(){
        return employeeService.getStudents();

    }

    @PostMapping
    public void registerNewEmployee(@RequestBody Employee employee){
        employeeService.addNewEmployee(employee);
    }

    @DeleteMapping(path = "{id}")
    public void deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);

    }


    @PutMapping(path = "{id}")
    public void updateEmployee(
            @PathVariable("id") long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        employeeService.updateEmployee(id,name,email);

    }

}
