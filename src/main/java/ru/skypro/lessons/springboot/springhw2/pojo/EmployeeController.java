package ru.skypro.lessons.springboot.springhw2.pojo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/salary/sum")
    public int getSumSalary() {
        return employeeService.getSumSalary();
    }

    @GetMapping("/salary/min")
    public int getMinSalary() {
        return employeeService.getMinSalary();
    }

    @GetMapping("/salary/max")
    public int getMaxSalary() {
        return employeeService.getMaxSalary();
    }

    @GetMapping("/high-salary")
    public List<Employee> getMaxSalaryEmployee() {
        return employeeService.getMaxSalaryEmployee();
    }
}
