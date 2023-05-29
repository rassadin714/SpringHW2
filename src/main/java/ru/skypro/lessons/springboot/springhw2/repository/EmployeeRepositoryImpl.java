package ru.skypro.lessons.springboot.springhw2.repository;

import ru.skypro.lessons.springboot.springhw2.pojo.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final List<Employee> employeeList = List.of(
            new Employee("Сергей", 100_000),
            new Employee("Алексей", 120_000),
            new Employee("Юлия", 90_000),
            new Employee("Елена", 180_000));

    @Override
    public int getSumSalary() {
        int sum = 0;
        for (Employee employee : employeeList) {
            sum += employee.getSalary();
        }
        return sum;
    }

    @Override
    public int getMinSalary() {
        int minSalary = 9999999;
        for (Employee employee : employeeList) {
            if (minSalary > employee.getSalary()) {
                minSalary = employee.getSalary();
            }
        }
        return minSalary;
    }

    @Override
    public int getMaxSalary() {
        int maxSalary = 0;
        for (Employee employee : employeeList) {
            if (maxSalary < employee.getSalary()) {
                maxSalary = employee.getSalary();
            }
        }
        return maxSalary;
    }

    @Override
    public List<Employee> getMaxSalaryEmployee() {
        List<Employee> midSalaryEmployee = new ArrayList<>();
        int midSalary = this.getSumSalary() / employeeList.size();
        for (Employee employee : employeeList) {
            if (employee.getSalary() > midSalary) {
                midSalaryEmployee.add(employee);
            }
        }
        return midSalaryEmployee;
    }
}
