package ru.skypro.lessons.springboot.springhw2.repository;

import ru.skypro.lessons.springboot.springhw2.exceptions.EmployeeNotFoundException;
import ru.skypro.lessons.springboot.springhw2.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    public List<Employee> getAllEmployees();

    void addEmployee(Employee employee);
    void editEmployee(String name, Integer salary, int id) throws EmployeeNotFoundException;
    Employee getEmployeeById(int id) throws EmployeeNotFoundException;
    void deleteEmployeeById (int id);

}
