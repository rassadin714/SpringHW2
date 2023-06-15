package ru.skypro.lessons.springboot.springhw2.service;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.springhw2.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.springhw2.dto.EmployeeFullInfo;
import ru.skypro.lessons.springboot.springhw2.model.Employee;

import java.util.List;

@Service

public interface EmployeeService {
    void addEmployee(EmployeeDTO employeeDTO);
    void editEmployee(String name, Integer salary, int id);
    EmployeeDTO getEmployeeById(int id);
    void deleteEmployeeById (int id);
    public EmployeeDTO getEmployeeWithHighestSalary();

    List<EmployeeDTO> getAllEmployees();
    List<EmployeeDTO> getEmployeesByPosition(String position);
    EmployeeFullInfo getEmployeeFullInfoById(int id);
    List<Employee> getEmployeesWithPaging(int page);
}
