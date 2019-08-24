package pl.sdacademy.javapoz19programowanie1.employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public List<Employee> sortByAge() {
        return employeeRepository.sortByAge();
    }

    public List<Employee> sortBySalary() {
        return employeeRepository.sortBySalary();
    }

    public Map<String, List<Employee>> groupByAgeSegment() {
        List<Employee> employees = findAll();

        return employees.stream()
                .collect(Collectors.groupingBy(employee -> calculateAgeSegment(employee.getAge())));
    }

    public Double getAvgSalaryOfAgeSegment(Integer age) {
        Map<String, List<Employee>> groups = groupByAgeSegment();
        String ageSegment = calculateAgeSegment(age);

        List<Employee> employees = groups.get(ageSegment);

        return (employees != null ? employees : new ArrayList<Employee>())
                .stream()
                .mapToInt(employee -> employee.getSalary())
                .average()
                .orElse(0.0);
    }

    private String calculateAgeSegment(Integer value) {
        Integer left = value - value % 5;
        Integer right = left + 5;
        return left + "-" + right;
    }

}
