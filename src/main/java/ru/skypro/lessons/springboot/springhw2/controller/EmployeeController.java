package ru.skypro.lessons.springboot.springhw2.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.springhw2.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.springhw2.dto.EmployeeFullInfo;
import ru.skypro.lessons.springboot.springhw2.model.Employee;
import ru.skypro.lessons.springboot.springhw2.service.EmployeeService;


import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    public void addEmployee (@RequestBody EmployeeDTO employeeDTO){
        employeeService.addEmployee(employeeDTO);
    }

    @PutMapping("{id}")
    public void editEmployee(@RequestParam(value = "name", required = false) String name,
                             @RequestParam (value = "salary", required = false) Integer salary,
                             @PathVariable("id") int id ) {
        employeeService.editEmployee(name, salary, id);
    }

    @GetMapping("{id}")
    public EmployeeDTO getEmployeeById (@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("{id}")
    public void deleteEmployeeById (@PathVariable int id){
        employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/withHighestSalary")
    public EmployeeDTO getEmployeeWithHighestSalary(){
        return employeeService.getEmployeeWithHighestSalary();
    }


    @GetMapping("/position")
    public List<EmployeeDTO> getEmployeesByPosition(@RequestParam(value = "position", required = false) String position) {
        return employeeService.getEmployeesByPosition(position);
    }

    @GetMapping("/{id}/fullInfo")
    public EmployeeFullInfo getEmployeeFullInfoById(@PathVariable int id) {
        return employeeService.getEmployeeFullInfoById(id);
    }

    @GetMapping("/page")
    public List<Employee> getEmployeesWithPaging(@RequestParam("page") int page){
        return employeeService.getEmployeesWithPaging(page);
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void createEmployeeFromFile(@RequestParam("file") MultipartFile file) throws IOException {
        employeeService.createEmployeeFromFile(file);
    }

}
