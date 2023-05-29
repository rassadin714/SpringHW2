package ru.skypro.lessons.springboot.springhw2.repository;

import ru.skypro.lessons.springboot.springhw2.pojo.Employee;

import java.util.List;

public interface EmployeeRepository {
    int getSumSalary();

    int getMinSalary();

    int getMaxSalary();

    List<Employee> getMaxSalaryEmployee();
}
