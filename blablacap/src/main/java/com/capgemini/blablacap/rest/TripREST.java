package com.capgemini.blablacap.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.blablacap.models.Trip;
import com.capgemini.blablacap.services.TripService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/trips")
public class TripREST {
    @Autowired
    private TripService tripService;
    private TripService tripRepository;

    @GetMapping
    private ResponseEntity<List<Trip>> getAllTrips() {
        return ResponseEntity.ok(tripService.findAll());
    }

    
    @PostMapping(value = "/settrip", 
                consumes = {MediaType.APPLICATION_JSON_VALUE})

        public ResponseEntity setVehicle(@RequestBody String tripString) {
            System.out.println(tripString);
        Trip trip;
        try {
           
            trip = tripService.getJson(tripString);
            if(trip != null){
                tripService.save(trip);
                 return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    
    /* @PostMapping("/create")
    public Trip createTrip(@RequestBody Trip trip) {
        System.out.println("Entrada en metodo con: " + trip.toString());
        Trip newtrip = new Trip (trip.getStart_point(), trip.getDest_office(), trip.getDeparture_date(), trip.getDeparture_time(), trip.getVehicle().getId(), trip.getAviable_seats(), trip.getPrice(), trip.getMeeting_point_desc(), trip.getUser().getId());

		
        return tripRepository.save(newtrip);
	}
 */
    /* @PostMapping("/create")
    public Trip createTrip(@RequestBody Trip trip) {
        System.out.println("Entrada en metodo con: " + trip.toString());
        return trip;
    } */

    @PostMapping(value = "/create", 
                consumes = {MediaType.APPLICATION_JSON_VALUE})

        public ResponseEntity createTrip(@RequestBody String tripString) {
            System.out.println("String de entrada: -->" + tripString);
        Trip trip;
        try {
           
            trip = tripService.getJson(tripString);
            if(trip != null){
                tripService.save(trip);
                 return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    /* Metodo para recibir y filtrar las busquedas  de viajes desde el front */
    @GetMapping("/search")
    public ResponseEntity<List<Trip>> getTripsByFilters(String filters) {
        List<Trip> trips = tripService.getTripListFiltered(filters);
        return ResponseEntity.ok(trips);
    }
}


