package com.capgemini.blablacap.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.capgemini.blablacap.models.Trip;
import com.capgemini.blablacap.repository.TripRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TripService implements TripRepository{
    @Autowired
    private TripRepository tripRepository;
    public static final String STRING_NULL = "null";

    public Trip getJson(String trip) throws IOException {
        System.out.println("ntrada al getJson: -->" + trip);
        if(trip!=null){
            Trip tripJson =new Trip();
        
            try {
                 ObjectMapper objectMapper = new ObjectMapper();
                tripJson = objectMapper.readValue(trip, Trip.class);
                System.out.println("tripJson: -->"+tripJson);
    
            } catch (IOException e) {
                e.printStackTrace();
            } 
            
            return tripJson;
        }

       return null;
    }
    /* Metodo de filtrado de las busquedas */
    public List<Trip> getTripListFiltered(String filters) {
        System.out.println("llegada: " + filters);
        String[] parts = filters.split("\\*");
        String origin = parts[0];
        String destination = parts[1];
        String date = parts[2];
        System.out.println("salida: " + "origin: " + origin + " dest: " + destination + " date: " + date);
        List<Trip> listTrips = findAll();
        List<Trip> resultado = new ArrayList<>();
            if (!STRING_NULL.equals(origin) && STRING_NULL.equals(destination) && STRING_NULL.equals(date)) {
                for ( Trip solotrip : listTrips ) {
                    if ( solotrip.getStart_point().contains(origin) ) {
                        resultado.add(solotrip);
                    }
                }
            } else if ( STRING_NULL.equals(origin) && !STRING_NULL.equals(destination) && STRING_NULL.equals(date)) {
                for ( Trip solotrip : listTrips ) {
                    if ( solotrip.getDest_office().contains(destination) ){
                        resultado.add(solotrip);
                    }
                }
            } else if ( STRING_NULL.equals(origin) && STRING_NULL.equals(destination) && !STRING_NULL.equals(date)) {
                for ( Trip solotrip : listTrips ) {
                    String dateOne = solotrip.getDeparture_date().toString();
                    if ( dateOne.equals(date) ){
                        resultado.add(solotrip);
                    }
                }
            } else if ( !STRING_NULL.equals(origin) && !STRING_NULL.equals(destination) && STRING_NULL.equals(date)) {
                for ( Trip solotrip : listTrips ) {
                    if ( solotrip.getStart_point().contains(origin) && solotrip.getDest_office().contains(destination) ) {
                        resultado.add(solotrip);
                    }
                }
            } else if ( STRING_NULL.equals(origin) && !STRING_NULL.equals(destination) && !STRING_NULL.equals(date)) {
                for ( Trip solotrip : listTrips ) {
                    String dateOne = solotrip.getDeparture_date().toString();
                    if ( solotrip.getDest_office().contains(destination) && dateOne.equals(date) ) {
                        resultado.add(solotrip);
                    }
                }
            } else if (!STRING_NULL.equals(origin) && STRING_NULL.equals(destination) && !STRING_NULL.equals(date)) {
                for ( Trip solotrip : listTrips ) {
                    String dateOne = solotrip.getDeparture_date().toString();
                    if ( solotrip.getStart_point().contains(origin) && dateOne.equals(date) ) {
                        resultado.add(solotrip);
                    }
                }
            } else {
                for ( Trip solotrip : listTrips ) {
                    String dateOne = solotrip.getDeparture_date().toString();
                    if ( solotrip.getStart_point().contains(origin) && solotrip.getDest_office().contains(destination) && dateOne.equals(date) ) {
                        resultado.add(solotrip);
                }
            }
    }
    System.out.println("Salida DEFINITIVA: " + resultado);
    return resultado;
}

    @Override
    public void flush() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public <S extends Trip> S saveAndFlush(S entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Trip> List<S> saveAllAndFlush(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Trip> entities) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> ids) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAllInBatch() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Trip getOne(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Trip getById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Trip getReferenceById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Trip> List<S> findAll(Example<S> example) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Trip> List<S> findAll(Example<S> example, Sort sort) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    @Override
    public List<Trip> findAllById(Iterable<Long> ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Trip> List<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void delete(Trip entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAll(Iterable<? extends Trip> entities) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean existsById(Long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Optional<Trip> findById(Long id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public <S extends Trip> S save(S entity) {
        return tripRepository.save(entity);
    }

    @Override
    public List<Trip> findAll(Sort sort) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<Trip> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Trip> long count(Example<S> example) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public <S extends Trip> boolean exists(Example<S> example) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public <S extends Trip> Page<S> findAll(Example<S> example, Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Trip, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends Trip> Optional<S> findOne(Example<S> example) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    
}
