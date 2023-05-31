package ru.skypro.lessons.springboot.springhw2.repository;

import ru.skypro.lessons.springboot.springhw2.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    int getSumSalary();
    Employee getEmployeeMinSalary();
    Employee getEmployeeMaxSalary();
    List<Employee> getEmployeesHighSalary();
}
