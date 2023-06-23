package ru.skypro.lessons.springboot.springhw2.dto;

import lombok.Getter;
import lombok.Setter;
import ru.skypro.lessons.springboot.springhw2.model.Employee;

import java.io.Serializable;

@Getter
@Setter
public class EmployeeDTO implements Serializable {
    private Integer id;
    private String name;
    private Integer salary;


    public static EmployeeDTO fromEmployee(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSalary(employee.getSalary());
        return employeeDTO;
    }

    public Employee toEmployee() {
        Employee employee = new Employee();
        employee.setId(this.getId());
        employee.setName(this.getName());
        employee.setSalary(this.getSalary());
        return employee;
    }
}
