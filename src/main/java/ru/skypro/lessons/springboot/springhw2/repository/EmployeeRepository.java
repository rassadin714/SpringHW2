package ru.skypro.lessons.springboot.springhw2.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import ru.skypro.lessons.springboot.springhw2.dto.EmployeeFullInfo;
import ru.skypro.lessons.springboot.springhw2.exceptions.EmployeeNotFoundException;
import ru.skypro.lessons.springboot.springhw2.model.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>, PagingAndSortingRepository<Employee, Integer> {
    @Query(value = "SELECT e FROM Employee e")
    List<Employee> findAllEmployees();

    @Query(value = "FROM Employee e "+
            "INNER JOIN Position p " +
            "ON e.position.idPosition = p.idPosition and p.namePosition = :namePosition")
    List<Employee> getEmployeesByPosition(@Param("namePosition") String position);

    @Query("SELECT new ru.skypro.lessons.springboot.weblibrary.dto." +
            "EmployeeFullInfo(e.name , e.salary , p.namePosition) " +
            "FROM Employee e join fetch Position p " +
            "WHERE e.position = p AND e.id = :id")
    EmployeeFullInfo getEmployeeFullInfoById(@Param("id") int id);

    @Query(value = "SELECT * FROM employee WHERE salary = (SELECT MAX(salary) from employee)",
            nativeQuery = true)
    Employee getEmployeeWithHighestSalary();

}
