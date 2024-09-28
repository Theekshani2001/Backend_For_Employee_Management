package com.example.demo.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

//    @Query("SELECT s FROM Employee s WHERE s.email = ?1")

// SELECT * FROM EMPLOYEE WHERE email=?
    Optional<Employee> findEmployeeByEmail(String email);
}
