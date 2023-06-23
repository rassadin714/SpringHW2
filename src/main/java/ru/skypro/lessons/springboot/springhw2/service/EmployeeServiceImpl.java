package ru.skypro.lessons.springboot.springhw2.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.springhw2.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.springhw2.dto.EmployeeFullInfo;
import ru.skypro.lessons.springboot.springhw2.exceptions.EmployeeNotFoundException;
import ru.skypro.lessons.springboot.springhw2.model.Employee;
import ru.skypro.lessons.springboot.springhw2.repository.EmployeeRepository;

import java.awt.print.Pageable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

//    @Override
//    public int getSumSalary() {
////        List<Employee> employeeList = new ArrayList<>(employeeRepository.getAllEmployees());
////        int sum = employeeList.stream()
////                .mapToInt(e -> e.getSalary())
////                .sum();
////        return sum;
//        return 0;
//    }
//
//    @Override
//    public Employee getEmployeeMinSalary() {
////        List<Employee> employeeList = new ArrayList<>(employeeRepository.getAllEmployees());
////        Employee employee = employeeList.stream()
////                .sorted(Comparator.comparing(Employee::getSalary))
////                .findFirst()
////                .get();
////        return employee;
//        return null;
//    }
//
//    @Override
//    public Employee getEmployeeMaxSalary() {
////        List<Employee> employeeList = new ArrayList<>(employeeRepository.getAllEmployees());
////        Employee employee = employeeList.stream()
////                .sorted(Comparator.comparing(Employee::getSalary).reversed())
////                .findFirst()
////                .get();
////        return employee;
//    return null;
//    }
//
//    @Override
//    public List<Employee> getEmployeesHighSalary() {
////        List<Employee> employeeList = new ArrayList<>(employeeRepository.getAllEmployees());
////
////        double averageSalary = employeeList.stream()
////                .mapToInt(Employee::getSalary)
////                .average().orElse(0);
////
////        List<Employee> employeesHighSalary = employeeList.stream()
////                .filter(e-> e.getSalary()>averageSalary)
////                .collect(Collectors.toList());
////
////        return employeesHighSalary;
//    return null;
//    }

    @Override
    public void addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeDTO.toEmployee();
        employeeRepository.save(employee);
    }

    @Override
    public void editEmployee(String name, Integer salary, int id) {
        EmployeeDTO employeeDTO = EmployeeDTO.fromEmployee(employeeRepository.findById(id)
                .orElseThrow(EmployeeNotFoundException::new));
        employeeDTO.setName(name);
        employeeDTO.setSalary(salary);
        Employee employee = employeeDTO.toEmployee();
        employeeRepository.save(employee);
    }

    @Override
    public EmployeeDTO getEmployeeById(int id) {

        EmployeeDTO employeeDTO = EmployeeDTO.fromEmployee(employeeRepository.findById(id)
                .orElseThrow(EmployeeNotFoundException::new));
        return  employeeDTO;
    }

    @Override
    public void deleteEmployeeById(int id) {

        EmployeeDTO employeeDTO = EmployeeDTO.fromEmployee(employeeRepository.findById(id)
                .orElseThrow(EmployeeNotFoundException::new));
        Employee employee = employeeDTO.toEmployee();
        employeeRepository.deleteById(employee.getId());
    }

//    @Override
//    public List<Employee> employeesSalaryHigherThan(int salary) {
////        List<Employee> employeeList = new ArrayList<>(employeeRepository.getAllEmployees());
////        List<Employee> employeesHigherSalaryThan = employeeList.stream()
////                .filter(e-> e.getSalary()>salary)
////                .collect(Collectors.toList());
////        return employeesHigherSalaryThan;
//    return null;
//    }

    @Override
    public List<EmployeeDTO> getAllEmployees(){
        return employeeRepository.findAllEmployees().stream()
                .map(EmployeeDTO::fromEmployee)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeWithHighestSalary() {
        Employee employee = employeeRepository.getEmployeeWithHighestSalary();
        EmployeeDTO employeeDTO = EmployeeDTO.fromEmployee(employee);
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> getEmployeesByPosition(String position) {
        List<Employee> employees = new ArrayList<>();
        List<EmployeeDTO> employeesDTO = new ArrayList<>();
        if(position == null){
            employees = employeeRepository.findAllEmployees();
            employeesDTO = employees.stream()
                    .map(EmployeeDTO::fromEmployee)
                    .collect(Collectors.toList());
        }else {
            employees = employeeRepository.getEmployeesByPosition(position);
            employeesDTO = employees.stream()
                    .map(EmployeeDTO::fromEmployee)
                    .collect(Collectors.toList());
        }
        return employeesDTO;
    }

    @Override
    public EmployeeFullInfo getEmployeeFullInfoById(int id) {
        return employeeRepository.getEmployeeFullInfoById(id);
    }

    @Override
    public List<Employee> getEmployeesWithPaging(int page) {
        Pageable employeeOfConcretePage = (Pageable) PageRequest.of(page, 10);
        Page<Employee> pageOfEmployee = employeeRepository.findAll((org.springframework.data.domain.Pageable) employeeOfConcretePage);

        return pageOfEmployee.stream()
                .toList();
    }

    @Override
    public void createEmployeeFromFile(MultipartFile file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        EmployeeDTO[] newEmployees = objectMapper.readValue(file.getBytes(), EmployeeDTO[].class);
        for (EmployeeDTO e : newEmployees) {
            createEmployee(e);
        }
    }

    @Override
    public void createEmployee(EmployeeDTO employeeDTO) {
        employeeRepository.save(employeeDTO.toEmployee());
    }

}
