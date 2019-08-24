package pl.sdacademy.javapoz19programowanie1.employee;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class EmployeeServiceTest {

    @Test
    public void findAllShouldReturnGivenEmployees() {
        // given
        List<Employee> employees = Arrays.asList(
                new Employee("name-1", 26, 5000),
                new Employee("name-2", 30, 3000),
                new Employee("name-3", 36, 6500)
        );

        EmployeeService employeeService = new EmployeeService(new InMemoryEmployeeRepository(employees));

        // when
        List<Employee> result = employeeService.findAll();

        // then
        Assert.assertEquals(employees, result);
    }

}