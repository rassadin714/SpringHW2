package ru.skypro.lessons.springboot.springhw2.controller;

import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.lessons.springboot.springhw2.service.ReportService;

import java.io.IOException;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @PostMapping(value = "/")
    public Integer createReport() throws IOException {
        return reportService.createReport();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Resource> getReportById(@PathVariable Integer id) throws IOException {
        return reportService.getReportById(id);
    }
}
