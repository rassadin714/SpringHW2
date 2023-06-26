package ru.skypro.lessons.springboot.springhw2.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import ru.skypro.lessons.springboot.springhw2.dto.EmployeeFullInfo;
import ru.skypro.lessons.springboot.springhw2.exceptions.EmployeeNotFoundException;
import ru.skypro.lessons.springboot.springhw2.model.Employee;

import java.util.Collection;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    @Query("SELECT new ru.skypro.lessons.springboot.weblibraryhw.dto." +
            "EmployeeFullInfo(e.name , e.salary , p.name) " +
            "FROM Employee e join fetch Position p " +
            "WHERE e.position = p")
    Collection<EmployeeFullInfo> findAllEmployeeFullInfo();

    @Query("SELECT new ru.skypro.lessons.springboot.weblibraryhw.dto." +
            "EmployeeFullInfo(e.name , e.salary , p.name) " +
            "FROM Employee e join fetch Position p " +
            "WHERE e.position = p AND e.id=?1")
    Optional<EmployeeFullInfo> findByIdFullInfo(Integer id);

    @Query("SELECT new ru.skypro.lessons.springboot.weblibraryhw.dto." +
            "EmployeeFullInfo(e.name , e.salary , p.name) " +
            "FROM Employee e join fetch Position p " +
            "WHERE e.position = p AND p.id=?1")
    Collection<EmployeeFullInfo> findEmployeeByPosition(Integer position);

    @Query("SELECT new ru.skypro.lessons.springboot.weblibraryhw.dto." +
            "EmployeeFullInfo(e.name, e.salary, p.name) " +
            "FROM Employee e join fetch Position p " +
            "WHERE e.position = p AND e.salary = (SELECT MAX(e2.salary) FROM Employee e2)")
    Collection<EmployeeFullInfo> findEmployeeWithHighestSalary();
}
