package ru.skypro.lessons.springboot.springhw2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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


    @PostMapping("/")
    public void addEmployee (@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @PutMapping("{id}")
    public void editEmployee(@RequestParam(value = "name", required = false) String name,
                             @RequestParam (value = "salary", required = false) Integer salary,
                             @PathVariable("id") int id ) {
        employeeService.editEmployee(name, salary, id);
    }

    @GetMapping("{id}")
    public Employee getEmployeeById (@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("{id}")
    public void deleteEmployeeById (@PathVariable int id){
        employeeService.deleteEmployeeById(id);
    }

    @GetMapping("salaryHigherThan")
    public List<Employee> employeesSalaryHigherThan(@RequestParam("salary") int salary){
        return employeeService.employeesSalaryHigherThan(salary);
    }

}
