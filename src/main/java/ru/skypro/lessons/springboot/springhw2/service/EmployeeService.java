package ru.skypro.lessons.springboot.springhw2.service;

import ru.skypro.lessons.springboot.springhw2.model.Employee;

import java.util.List;

public interface EmployeeService {

    Integer salarySum();

    Employee findEmployeeWithMinSalary();

    Employee findEmployeeWithMaxSalary();

    List<Employee> aboveAverageSalary();

    void addEmployee(Employee employees);
    void editEmployee(String name, Integer salary, int id);
    Employee getEmployeeById(int id);
    void deleteEmployeeById (int id);
    List<Employee> employeesSalaryHigherThan(int salary);
}
