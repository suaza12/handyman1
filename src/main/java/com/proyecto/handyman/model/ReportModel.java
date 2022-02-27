package com.proyecto.handyman.model;

import com.proyecto.handyman.entity.Report;

public class ReportModel extends Report {
    private String idHandyman;
    private int week;
    private int horasNormales;
    private int horasNormalesExtra;
    private int horasNocturnas;
    private int horasNocturnasExtra;
    private int horasDomingo;
    private int horasDomingoExtra;
    private int totalHoras;

    public String getIdHandyman() {
        return idHandyman;
    }

    public void setIdHandyman(String idHandyman) {
        this.idHandyman = idHandyman;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getHorasNormales() {
        return horasNormales;
    }

    public void setHorasNormales(int horasNormales) {
        this.horasNormales = horasNormales;
    }

    public int getHorasNormalesExtra() {
        return horasNormalesExtra;
    }

    public void setHorasNormalesExtra(int horasNormalesExtra) {
        this.horasNormalesExtra = horasNormalesExtra;
    }

    public int getHorasNocturnas() {
        return horasNocturnas;
    }

    public void setHorasNocturnas(int horasNocturnas) {
        this.horasNocturnas = horasNocturnas;
    }

    public int getHorasNocturnasExtra() {
        return horasNocturnasExtra;
    }

    public void setHorasNocturnasExtra(int horasNocturnasExtra) {
        this.horasNocturnasExtra = horasNocturnasExtra;
    }

    public int getHorasDomingo() {
        return horasDomingo;
    }

    public void setHorasDomingo(int horasDomingo) {
        this.horasDomingo = horasDomingo;
    }

    public int getHorasDomingoExtra() {
        return horasDomingoExtra;
    }

    public void setHorasDomingoExtra(int horasDomingoExtra) {
        this.horasDomingoExtra = horasDomingoExtra;
    }

    public int getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(int totalHoras) {
        this.totalHoras = totalHoras;
    }


}
