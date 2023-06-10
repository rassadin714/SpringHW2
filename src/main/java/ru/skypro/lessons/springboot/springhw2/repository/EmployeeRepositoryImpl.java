package ru.skypro.lessons.springboot.springhw2.repository;


import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.springhw2.exceptions.EmployeeNotFoundException;
import ru.skypro.lessons.springboot.springhw2.model.Employee;
import ru.skypro.lessons.springboot.springhw2.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee("Сергей", 100_000, 1),
            new Employee("Алексей", 120_000, 2),
            new Employee("Юлия", 90_000,3),
            new Employee("Елена", 180_000, 4),
            new Employee("Антон", 110_000, 5)
    ));

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public void addEmployee(Employee employee) {
        getAllEmployees().add(employee);
    }

    @Override
    public void editEmployee(String name, Integer salary, int id) {

        getAllEmployees().stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .map(employee -> {
                    if (!name.isEmpty()){
                        employee.setName(name);
                    }
                    if (salary!=null) {
                        employee.setSalary(salary);
                    }
                    return employee;
                }).orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = getAllEmployees().stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);
        return employee;
    }

    @Override
    public void deleteEmployeeById(int id) {
        Employee employee = getAllEmployees().stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);
        getAllEmployees().remove(employee);
    }

}
