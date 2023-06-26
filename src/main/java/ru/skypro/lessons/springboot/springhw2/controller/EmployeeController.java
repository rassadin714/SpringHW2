package ru.skypro.lessons.springboot.springhw2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.springhw2.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.springhw2.dto.EmployeeFullInfo;
import ru.skypro.lessons.springboot.springhw2.model.Employee;
import ru.skypro.lessons.springboot.springhw2.service.EmployeeService;


import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    @GetMapping
    public Collection<EmployeeFullInfo> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/salary/sum")
    public Integer getSalarySum() {
        return employeeService.getSalarySum();
    }
    @GetMapping("/salary/min")
    public EmployeeFullInfo getSalaryMin() {
        return employeeService.getSalaryMin();
    }
    @GetMapping("/salary/max")
    public EmployeeFullInfo getSalaryMax() {
        return employeeService.getSalaryMax();
    }
    @GetMapping("/high-salary")
    public Collection<EmployeeFullInfo> getSalaryAboveAverageEmployees() {
        return employeeService.getSalaryAboveAverageEmployees();
    }
    @PostMapping("/employees")
    public void createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.createEmployee(employeeDTO);
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/employees/salaryHigherThan")
    public Collection<EmployeeFullInfo> getEmployeesByParamSalary(@RequestParam("paramSalary") int paramSalary) {
        return employeeService.getEmployeesByParamSalary(paramSalary);
    }
    @PutMapping("/employees/{id}")
    public void updateEmployeeById(@PathVariable Integer id, @RequestBody EmployeeDTO employeeDTO) {
        employeeService.updateEmployeeById(id, employeeDTO);
    }
    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
    }
    @GetMapping("/employees/{id}/fullInfo")
    public EmployeeFullInfo getEmployeeByIdFullInfo(@PathVariable Integer id) {
        return employeeService.getEmployeeByIdFullInfo(id);
    }
    @GetMapping("/employees/position")
    public Collection<EmployeeFullInfo> getEmployeesByPosition(@RequestParam Optional<Integer> position) {
        return employeeService.getEmployeesByPosition(position.orElse(null));
    }
    @GetMapping("/employees/withHighestSalary")
    public Collection<EmployeeFullInfo> getEmployeesWithHighestSalary() {
        return employeeService.getEmployeesWithHighestSalary();
    }
    @GetMapping("/employees/page")
    public Collection<EmployeeDTO> getEmployeeWithPage(@RequestParam("page") Integer page) {
        return employeeService.getEmployeeWithPage(page);
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void createEmployeeFromFile(@RequestParam("file") MultipartFile file) throws IOException {
        employeeService.createEmployeeFromFile(file);
    }
}
