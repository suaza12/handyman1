package com.proyecto.handyman.repository;

import com.proyecto.handyman.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ServiceRepository extends JpaRepository<ServiceEntity, String> {

}
