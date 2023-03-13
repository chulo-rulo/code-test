package com.capgemini.blablacap.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "license_plate")
    private String license_plate;

    @Column(name = "year")
    private Date year;

    @Column(name = "model")
    private String model;

    @Column(name = "seats")
    private int seats;

    @Column(name = "color")
    private String color;

    @Column(name = "image")
    private byte[] image;


    public Vehicle() {
    }


    public Vehicle(String license_plate, Date year, String model, int seats, String color, byte[] image) {
        this.license_plate = license_plate;
        this.year = year;
        this.model = model;
        this.seats = seats;
        this.color = color;
        this.image = image;
    }
    

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicense_plate() {
        return this.license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public Date getYear() {
        return this.year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeats() {
        return this.seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public byte[] getImage() {
        return this.image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}
