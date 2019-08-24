package pl.sdacademy.javapoz19programowanie1.employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();
}
