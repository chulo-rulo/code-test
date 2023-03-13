package com.capgemini.blablacap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.blablacap.models.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
    
}
