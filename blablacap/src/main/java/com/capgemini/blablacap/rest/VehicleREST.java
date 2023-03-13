package com.capgemini.blablacap.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.capgemini.blablacap.models.Vehicle;
import com.capgemini.blablacap.services.VehicleService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/vehicles")
public class VehicleREST {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    private ResponseEntity<List<Vehicle>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.findAll());
    }

     @PostMapping(value = "/setvehicle", 
                consumes = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.MULTIPART_FORM_DATA_VALUE})

    public HttpStatus setVehicle(@RequestPart("data") String vehicleString, @RequestPart("file") MultipartFile file) {
        Vehicle vehicle;
        try {
            System.out.println("Coche:"+ vehicleString);
            vehicle = vehicleService.getJson(vehicleString,file);
            vehicleService.save(vehicle);
            return HttpStatus.OK;
        } catch (IOException e) {
            e.printStackTrace();
            return HttpStatus.UNSUPPORTED_MEDIA_TYPE;
        }
        
    }
    
}
