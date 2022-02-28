package com.proyecto.handyman.controller;


import com.proyecto.handyman.entity.Report;
import com.proyecto.handyman.model.ReportModel;
import com.proyecto.handyman.repository.ReportRepository;
import com.proyecto.handyman.utils.HoursWorked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping ("/api")
public class
ReportController {
    @Autowired
    private ReportRepository reportRepository;


    @PostMapping("/report")
    public ResponseEntity create(@RequestBody Report report) throws ParseException {
        Date startDate = HoursWorked.formatDate(report.getStartDate());
        Date endDate = HoursWorked.formatDate(report.getEndDate());
        if(startDate.before(endDate)) {
            report.setWeek(HoursWorked.calculateWeek(startDate));
            report.setTotalHoursService(HoursWorked.calculateHourService(startDate, endDate));
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(reportRepository.save(report));
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Start date cannot be greater than end date");
    }

    @GetMapping("/report")
    public List<Report> findAll() { return reportRepository.findAll(); }

    @GetMapping("/getservice")
    public List<Report> findByIdHandyman(@RequestParam String idHandyman, @RequestParam int week) {
        List<Report> results = findAll();
        List<Report> finalList = new ArrayList<>();
        for(Report rs: results) {
            if(rs.getIdHandyman().equals(idHandyman) && rs.getWeek() == week){
                finalList.add(rs);
            }
        }
        return finalList;
    }

    @DeleteMapping("/report/{id}")
    public void deleteProduct(@PathVariable("id") String id) {

        reportRepository.deleteById(Integer.valueOf(id));
    }

    @GetMapping("/results")
    public List<Report> findHours(@RequestParam String idHandyman, @RequestParam int week) throws ParseException{
        List<Report>  results = findByIdHandyman(idHandyman, week);
        List<Report> finalList = new ArrayList<>();
        ReportModel finalReport = new ReportModel();

        int sumhorasDomingo= 0;
        int sumhorasTotales = 0;
        int sumhorasNocturnas = 0;
        int sumhorasExtras = 0;
        int sumhorasExtrasDomingo = 0;
        int sumhorasExtrasNocturnas = 0;
        int sumhorasNormales = 0;

        for (Report rs : results) {
            Date StartDate = HoursWorked.formatDate(rs.getStartDate());
            Date EndDate = HoursWorked.formatDate(rs.getEndDate());
            sumhorasNormales += HoursWorked.calculateHorasComunes(StartDate, EndDate);
            sumhorasTotales += HoursWorked.calculateHourService(StartDate, EndDate);
            sumhorasDomingo += HoursWorked.calculateHorasDominicales(StartDate,EndDate,sumhorasDomingo);
            sumhorasNocturnas += HoursWorked.calculateHorasNocturnas(StartDate, EndDate);
            sumhorasExtras += HoursWorked.calculateHorasExtras(sumhorasNormales);
            sumhorasExtras += HoursWorked.calculateHorasExtrasDomingo(StartDate, EndDate,sumhorasExtrasDomingo);
            sumhorasExtrasNocturnas += HoursWorked.calculateHorasExtrasNocturnas(StartDate,EndDate,sumhorasExtrasNocturnas);

            finalReport.setIdHandyman(idHandyman);
            finalReport.setWeek(HoursWorked.calculateWeek(StartDate));
        }
        finalReport.setHorasNormalesExtra(sumhorasExtras);
        finalReport.setHorasDomingo(sumhorasDomingo);
        finalReport.setHorasDomingoExtra(sumhorasExtrasDomingo);
        finalReport.setHorasNormalesExtra(sumhorasExtrasNocturnas);
        finalReport.setHorasNocturnas(sumhorasNocturnas-sumhorasExtrasNocturnas);
        finalReport.setTotalHoras( sumhorasTotales);
        finalReport.setHorasNormales(sumhorasNormales-sumhorasExtras-sumhorasExtrasDomingo-sumhorasExtrasNocturnas-sumhorasNocturnas);

        finalList.add(finalReport);
        return finalList;
        }
    }