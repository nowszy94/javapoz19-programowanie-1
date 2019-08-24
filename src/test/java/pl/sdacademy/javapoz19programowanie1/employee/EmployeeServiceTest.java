package pl.sdacademy.javapoz19programowanie1.employee;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class EmployeeServiceTest {

    List<Employee> employeeList = Arrays.asList(
            new Employee("name1", "15000", 26),
            new Employee("name2", "1000", 29),
            new Employee("name3", "6000", 16)
    );

    @Test
    public void findAll_ShouldReturnGivenEmployees() {
        // given
        EmployeeService employeeService = new EmployeeService(new InMemoryEmployeeRepository(employeeList));

        //when
        List<Employee> result = employeeService.findAll();

        //then
        Assert.assertEquals(employeeList, result);
    }

    @Test
    public void sortByAge_ShouldReturnGivenEmployeesSortedByAge() {
        // given
        EmployeeService employeeService = new EmployeeService(new InMemoryEmployeeRepository(employeeList));

        //when
        List<Employee> result = employeeService.sortByAge();

        //then
        Assert.assertEquals(employeeList.get(0), result.get(1));
        Assert.assertEquals(employeeList.get(1), result.get(2));
        Assert.assertEquals(employeeList.get(2), result.get(0));
        System.out.println(result);
    }

    @Test
    public void sortBySalary_ShouldReturnGivenEmployeesSortedBySalary() {
        // given
        EmployeeService employeeService = new EmployeeService(new InMemoryEmployeeRepository(employeeList));

        //when
        List<Employee> result = employeeService.sortBySalary();

        //then
        Assert.assertEquals(employeeList.get(0), result.get(2));
        Assert.assertEquals(employeeList.get(1), result.get(0));
        Assert.assertEquals(employeeList.get(2), result.get(1));
        System.out.println(result);
    }

    @Test
    public void groupByAgeSegment_ShouldReturnMapWitchAgeSegmentAsKeyAndListOfEmployeesAsValue() {
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
                new Employee("name1", "1000", 31),
                new Employee("name2", "2000", 33),
                new Employee("name3", "6000", 36)
        );
        EmployeeService employeeService = new EmployeeService(new InMemoryEmployeeRepository(employees));

        // when
        Double result = employeeService.getAvgSalaryOfAgeSegment(32);

        // then
        Assert.assertEquals(1500, result, 0.1);
    }

    @Test
    public void getAvgSalaryOfAgeSegment_ShouldReturnZeroWhenEmployeesForGivenAgeSegmentAreNotExist() {
        // given
        List<Employee> employees = Arrays.asList(
                new Employee("name1", "1000", 31),
                new Employee("name2", "2000", 33),
                new Employee("name3", "15000", 36)
        );
        EmployeeService employeeService = new EmployeeService(new InMemoryEmployeeRepository(employees));

        // when
        Double result = employeeService.getAvgSalaryOfAgeSegment(50);

        // then
        Assert.assertEquals(0, result, 0.1);
    }

}