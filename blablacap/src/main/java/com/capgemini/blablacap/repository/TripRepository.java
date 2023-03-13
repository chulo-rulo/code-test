package com.capgemini.blablacap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.blablacap.models.Trip;

public interface TripRepository extends JpaRepository<Trip, Long> {
    
}
