package ru.skypro.lessons.springboot.springhw2.repository;


import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.springhw2.model.Employee;
import ru.skypro.lessons.springboot.springhw2.repository.EmployeeRepository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final List<Employee> employeeList = List.of(
            new Employee("Сергей", 100_000),
            new Employee("Алексей", 120_000),
            new Employee("Юлия", 90_000),
            new Employee("Елена", 180_000));

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }
}
