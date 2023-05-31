package ru.skypro.lessons.springboot.springhw2.service;

import ru.skypro.lessons.springboot.springhw2.model.Employee;

import java.util.List;

public interface EmployeeService {
    int getSumSalary();
    Employee getEmployeeMinSalary();
    Employee getEmployeeMaxSalary();
    List<Employee> getEmployeesHighSalary();
}
