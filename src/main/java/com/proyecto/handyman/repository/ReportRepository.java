package com.proyecto.handyman.repository;


import com.proyecto.handyman.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {

}
