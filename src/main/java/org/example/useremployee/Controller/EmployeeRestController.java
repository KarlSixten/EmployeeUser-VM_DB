package org.example.useremployee.Controller;

import org.example.useremployee.model.Employee;
import org.example.useremployee.model.User;
import org.example.useremployee.repositories.EmployeeRepository;
import org.example.useremployee.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRestController {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/employees")
    public List<Employee> getUsers() {
        return employeeRepository.findAll();
    }

    @PostMapping("/employees/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee postEmployee(@RequestBody Employee employee) {
        System.out.println(employee);
        return employeeRepository.save(employee);
    }

    @PostMapping("/users/add")
    @ResponseStatus(HttpStatus.CREATED)
    public User postUser(@RequestBody User user) {
        System.out.println(user);
        return userRepository.save(user);
    }
}
