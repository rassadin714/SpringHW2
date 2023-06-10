package ru.skypro.lessons.springboot.springhw2.service;


import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.springhw2.model.Employee;
import ru.skypro.lessons.springboot.springhw2.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Integer salarySum() {
        int sumSalary = 0;
        List<Integer> salaryList = employeeRepository.getAllEmployees()
                .stream()
                .map(Employee::getSalary)
                .toList();
        for (Integer salary : salaryList) {
            sumSalary = sumSalary + salary;
        }
        return sumSalary;
    }

    @Override
    public Employee findEmployeeWithMinSalary() {
        return employeeRepository.getAllEmployees()
                .stream()
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee findEmployeeWithMaxSalary() {
        return employeeRepository.getAllEmployees()
                .stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public List<Employee> aboveAverageSalary() {
        int sizeRepository = employeeRepository.getAllEmployees().size();
        int averageSalary = salarySum() / sizeRepository;
        return employeeRepository.getAllEmployees()
                .stream()
                .filter(employee -> employee.getSalary() > averageSalary)
                .collect(Collectors.toList());
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    @Override
    public void editEmployee(String name, Integer salary, int id) {
        employeeRepository.editEmployee(name, salary, id);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.getEmployeeById(id);
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteEmployeeById(id);
    }

    @Override
    public List<Employee> employeesSalaryHigherThan(int salary) {
        List<Employee> employeeList = new ArrayList<>(employeeRepository.getAllEmployees());
        List<Employee> employeesHigherSalaryThan = employeeList.stream()
                .filter(e-> e.getSalary()>salary)
                .collect(Collectors.toList());
        return employeesHigherSalaryThan;
    }
}
