package ru.skypro.lessons.springboot.springhw2.pojo;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.springhw2.repository.EmployeeRepository;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public int getSumSalary() {
        return employeeRepository.getSumSalary();
    }

    @Override
    public int getMinSalary() {
        return employeeRepository.getMinSalary();
    }

    @Override
    public int getMaxSalary() {
        return employeeRepository.getMaxSalary();
    }

    @Override
    public List<Employee> getMaxSalaryEmployee() {
        return employeeRepository.getMaxSalaryEmployee();
    }

}
