package ru.skypro.lessons.springboot.springhw2.service;

import ru.skypro.lessons.springboot.springhw2.model.Employee;

import java.util.List;

public interface EmployeeService {

    Integer salarySum();

    Employee findEmployeeWithMinSalary();

    Employee findEmployeeWithMaxSalary();

    List<Employee> aboveAverageSalary();
}
