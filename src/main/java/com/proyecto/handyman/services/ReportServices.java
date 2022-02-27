package com.proyecto.handyman.services;

import com.proyecto.handyman.entity.Report;
import com.proyecto.handyman.repository.ReportRepository;

import java.util.List;

public class ReportServices {
    private ReportRepository repository;

    public ReportServices(ReportRepository repository) {
        this.repository = repository;
    }



}
