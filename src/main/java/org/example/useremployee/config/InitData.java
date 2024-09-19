package org.example.useremployee.config;

import org.example.useremployee.model.Employee;
import org.example.useremployee.model.Gender;
import org.example.useremployee.model.User;
import org.example.useremployee.repositories.EmployeeRepository;
import org.example.useremployee.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setEmail("lol@lol.com");
        user1.setPassword("oajnsd");
        userRepository.save(user1);

        Employee employee1 = new Employee();
        employee1.setBorn(LocalDateTime.of(1990, 5, 10, 16, 10, 12));
        employee1.setName("Jens");
        employee1.setGender(Gender.MALE);
        employee1.setVegetarian(true);
        employee1.setUser(user1);
        employeeRepository.save(employee1);
    }
}
