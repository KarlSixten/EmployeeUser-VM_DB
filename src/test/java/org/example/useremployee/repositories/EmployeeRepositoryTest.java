package org.example.useremployee.repositories;

import org.example.useremployee.model.Employee;
import org.hibernate.JDBCException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    void testAtLeastOneJens() {
        List<Employee> employees = employeeRepository.findEmployeeByName("Jens");
        assertTrue(employees.size()>0);
    }

    @Test
    void testDeleteEmployee() {
        List<Employee> employees = employeeRepository.findEmployeeByName("Jens");
        Employee employee1 = employees.get(0);
        assertEquals("Jens", employee1.getName());
        assertThrows(org.springframework.dao.DataIntegrityViolationException.class, () -> userRepository.delete(employee1.getUser()));
    }

}