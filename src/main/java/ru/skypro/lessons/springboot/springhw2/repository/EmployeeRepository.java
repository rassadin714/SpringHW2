package ru.skypro.lessons.springboot.springhw2.repository;

import ru.skypro.lessons.springboot.springhw2.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    public List<Employee> getAllEmployees();

}
