package ru.skypro.lessons.springboot.springhw2.service;


import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface ReportService {
    Integer createReport() throws IOException;

    ResponseEntity<Resource> getReportById(Integer id) throws IOException;
}