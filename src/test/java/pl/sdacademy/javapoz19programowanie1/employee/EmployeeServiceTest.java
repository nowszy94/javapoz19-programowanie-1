package pl.sdacademy.javapoz19programowanie1.employee;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    @Test
    public void sortByAgeShouldReturnSortedList() {
        // given
        List<Employee> employees = Arrays.asList(
                new Employee("name-1", 36, 5000),
                new Employee("name-2", 25, 3000),
                new Employee("name-3", 46, 6500)
        );
        EmployeeService employeeService = new EmployeeService(new InMemoryEmployeeRepository(employees));

        // when
        List<Employee> result = employeeService.sortByAge();

        // then
        Assert.assertEquals(employees.get(1), result.get(0));
        Assert.assertEquals(employees.get(0), result.get(1));
        Assert.assertEquals(employees.get(2), result.get(2));
    }

    @Test
    public void sortBySalaryShouldReturnSortedList() {
        // given
        List<Employee> employees = Arrays.asList(
                new Employee("name-1", 36, 5000),
                new Employee("name-2", 25, 13000),
                new Employee("name-3", 46, 6500)
        );
        EmployeeService employeeService = new EmployeeService(new InMemoryEmployeeRepository(employees));

        // when
        List<Employee> result = employeeService.sortBySalary();

        // then
        Assert.assertEquals(employees.get(0), result.get(0));
        Assert.assertEquals(employees.get(2), result.get(1));
        Assert.assertEquals(employees.get(1), result.get(2));
    }

    @Test
    public void groupByAgeSegmentShouldReturnMapWithAgeSegmentAsKeyAndListOfEmployeesAsValue() {
        // given
        EmployeeService employeeService = new EmployeeService(new InMemoryEmployeeRepository());

        // when
        Map<String, List<Employee>> result = employeeService.groupByAgeSegment();

        // then
        System.out.println();
    }

    @Test
    public void getAvgSalaryOfAgeSegment_ShouldReturnAverageOfSalaryForEmployeesInAgeSegment() {
        // given
        List<Employee> employees = Arrays.asList(
                new Employee("name-1", 31, 1000),
                new Employee("name-2", 33, 2000),
                new Employee("name-3", 36, 50000)
        );
        EmployeeService employeeService = new EmployeeService(new InMemoryEmployeeRepository(employees));

        // when
        Double result = employeeService.getAvgSalaryOfAgeSegment(32);

        // then
        Assert.assertEquals(1500.0, result, 0.1);
    }

    @Test
    public void getAvgSalaryOfAgeSegment_ShouldReturnZeroWhenEmployeesForGivenAgeSegmentAreNotExist() {
        // given
        List<Employee> employees = Arrays.asList(
                new Employee("name-1", 31, 1000),
                new Employee("name-2", 33, 2000),
                new Employee("name-3", 36, 50000)
        );
        EmployeeService employeeService = new EmployeeService(new InMemoryEmployeeRepository(employees));

        // when
        Double result = employeeService.getAvgSalaryOfAgeSegment(50);

        // then
        Assert.assertEquals(0.0, result, 0.1);
    }
}