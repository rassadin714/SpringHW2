package ru.skypro.lessons.springboot.springhw2.model;

import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
    private String name;
    private int salary;

}
