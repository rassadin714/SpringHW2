package ru.skypro.lessons.springboot.springhw2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.skypro.lessons.springboot.springhw2.model.Report;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class ReportDTO implements Serializable {
    private Integer id;
    private String filePath;
    private String positionName;
    private Long count;
    private int minSalary;
    private int maxSalary;
    private double avgSalary;

    public ReportDTO(String positionName, Long count, int minSalary, int maxSalary, double avgSalary) {
        this.positionName = positionName;
        this.count = count;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.avgSalary = avgSalary;
    }

    public static ReportDTO fromReport(Report report) {
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setId(report.getId());
        reportDTO.setFilePath(report.getFilePath());
        return reportDTO;
    }

    @Override
    public String toString() {
        return "Отчет по отделам \n" +
                "Название отдела " + positionName + '\n' +
                "Количество сотрудников " + count + '\n' +
                "Минимальная зарплата по отделу " + minSalary + '\n' +
                "Максимальная зарплата по отделу " + maxSalary + '\n' +
                "Средняя зарплата " + avgSalary + '\n';
    }
}
