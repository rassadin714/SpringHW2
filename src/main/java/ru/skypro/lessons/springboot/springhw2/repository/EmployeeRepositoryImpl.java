package ru.skypro.lessons.springboot.springhw2.repository;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.springhw2.model.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository{

    private final static List<Employee> EMPLOYEE_LIST = List.of(
            new Employee("Сергей", 100_000),
            new Employee("Алексей", 120_000),
            new Employee("Юлия", 90_000),
            new Employee("Елена", 180_000)
    );


    @Override
    public int getSumSalary() {
        List<Employee> employeeList = new ArrayList<>(EMPLOYEE_LIST);
        int sum = employeeList.stream()
                .mapToInt(e -> e.getSalary())
                .sum();
        return sum;
    }

    @Override
    public Employee getEmployeeMinSalary() {
        List<Employee> employeeList = new ArrayList<>(EMPLOYEE_LIST);
        Employee employee = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .findFirst()
                .get();
        return employee;
    }

    @Override
    public Employee getEmployeeMaxSalary() {
        List<Employee> employeeList = new ArrayList<>(EMPLOYEE_LIST);
        Employee employee = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .findFirst()
                .get();
        return employee;
    }

    @Override
    public List<Employee> getEmployeesHighSalary() {
        List<Employee> employeeList = new ArrayList<>(EMPLOYEE_LIST);

        double averageSalary = employeeList.stream()
                .mapToInt(Employee::getSalary)
                .average().orElse(0);

        List<Employee> employeesHighSalary = employeeList.stream()
                .filter(e-> e.getSalary()>averageSalary)
                .collect(Collectors.toList());

        return employeesHighSalary;
    }
}
