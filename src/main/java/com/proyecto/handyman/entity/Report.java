package com.proyecto.handyman.entity;

import javax.persistence.*;

@Entity
@Table(name= "ReportServices")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String idHandyman;
    private String idService;
    private String startDate;
    private String endDate;
    private int week;
    private String reportDescription;
    private int TotalHoursService;

    public int getId() {
        return id;
    }

    public String getIdHandyman() {
        return idHandyman;
    }

    public void setIdHandyman(String idHandyman) {
        this.idHandyman = idHandyman;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getReportDescription() {
        return reportDescription;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }

    public int getTotalHoursService() {
        return TotalHoursService;
    }

    public void setTotalHoursService(int totalHoursService) {
        TotalHoursService = totalHoursService;
    }
}