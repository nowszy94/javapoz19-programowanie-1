package pl.sdacademy.javapoz19programowanie1.employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeService {
    private EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public List<Employee> sortBySalary() {
        return repository.sortBySalary();
    }

    public List<Employee> sortByAge() {
        return repository.sortByAge();
    }

    public Map<String, List<Employee>> groupByAgeSegment() {
        List<Employee> employees = findAll();

        return employees.stream()
                .collect(Collectors.groupingBy(employee -> {
                    Integer n = employee.getAge();
                    return calculateAgeSegment(n);
                }));
    }

    private String calculateAgeSegment(Integer age) {
        Integer left = age - age % 5;
        Integer right = left - 5;
        return left + "-" + right;
    }

    public Double getAvgSalaryOfAgeSegment(Integer age) {
        Map<String, List<Employee>> groups = groupByAgeSegment();
        String ageSegment = calculateAgeSegment(age);

        List<Employee> employees = groups.get(ageSegment);

        return (employees != null ? employees : new ArrayList<Employee>()).stream()
            .mapToDouble(employee -> employee.getSalary())
            .average()
            .orElse(0.0);
    }
}
