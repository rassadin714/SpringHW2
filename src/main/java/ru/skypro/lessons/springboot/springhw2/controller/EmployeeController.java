package ru.skypro.lessons.springboot.springhw2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.lessons.springboot.springhw2.model.Employee;
import ru.skypro.lessons.springboot.springhw2.service.EmployeeService;


import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/salary/max")
    public Employee findEmployeeWithMaxSalary() {
        return employeeService.findEmployeeWithMaxSalary();
    }

    @GetMapping("/salary/min")
    public Employee findEmployeeWithMinSalary() {
        return employeeService.findEmployeeWithMinSalary();
    }

    @GetMapping("/salary/sum")
    public Integer salarySum() {
        return employeeService.salarySum();
    }

    @GetMapping("/high-salary")
    public List<Employee> highSalary() {
        return employeeService.aboveAverageSalary();
    }

}
