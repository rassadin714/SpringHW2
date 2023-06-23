package ru.skypro.lessons.springboot.springhw2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "report")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "filePath", columnDefinition = "text")
    private String filePath;

    @Override
    public String toString() {
        return "Отчет: " +
                "номер отчета: " + id +
                ", содержание: " + filePath + '\n';
    }
}
