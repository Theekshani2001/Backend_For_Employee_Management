package com.example.demo.employee;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository){
        return args -> {

            Employee tharindi =new Employee(
                    "tharindi@gamil.com",
                    "Tharindi",
                    LocalDate.of(2001,5,8)
            );

            Employee theekshani =new Employee(
                    "theekshani@gamil.com",
                    "Theekshani",
                    LocalDate.of(2002,4,8)
            );

            repository.saveAll(
                    List.of(tharindi,theekshani)
            );

        };
    }
}
