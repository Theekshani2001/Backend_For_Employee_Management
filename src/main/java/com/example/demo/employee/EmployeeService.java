package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Autowired
    public List<Employee> getStudents(){
        return employeeRepository.findAll();
    }

    public void addNewEmployee(Employee employee) {
        Optional<Employee> employeeOptional= employeeRepository.findEmployeeByEmail(employee.getEmail());

        if(employeeOptional.isPresent()){
            throw new IllegalStateException("Email is Taken");
        }else {
            employeeRepository.save(employee);
        }
    }

    public void deleteEmployee(Long id) {

        boolean exists = employeeRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Employee with id "+id+" does not exists");
        }else {
            employeeRepository.deleteById(id);
        }
    }


@Transactional
    public void updateEmployee(long id, String name, String email) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalStateException("Employee with id "+id+" does not exists"));

        if(name!=null && name.length()>0 && !Objects.equals(employee.getName(),name)){
            employee.setName(name);
        }

        if(email!=null && name.length()>0 && !Objects.equals(employee.getEmail(),email)){
            Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(email);
            if(employeeOptional.isPresent()){
                throw new IllegalStateException("Email is Taken");
            }else {
                employee.setEmail(email);
            }
        }
    }
}
