package com.proyecto.handyman.controller;

import com.proyecto.handyman.entity.Report;
import com.proyecto.handyman.entity.ServiceEntity;
import com.proyecto.handyman.repository.ServiceRepository;
import com.proyecto.handyman.utils.HoursWorked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping
public class ServiceController {
    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping("/service")
    public List<ServiceEntity> findAll(){return serviceRepository.findAll() ;}


//    @PostMapping("/service")
//    public ServiceEntity create(@RequestBody ServiceEntity serviceEntity) throws ParseException{
//        String idServices = new ServiceEntity(serviceEntity.getIdService());
//        String typeService = new ServiceEntity(serviceEntity.getTypeService());
//        return serviceRepository.save(serviceEntity);
//    }
}
