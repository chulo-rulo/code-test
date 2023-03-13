package com.capgemini.blablacap.models;

import java.sql.Time;
import java.time.LocalTime;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "trip")
public class Trip {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "departure_date")
    private Date departure_date;

    @Column(name = "departure_time")
    private Time departure_time;

    @Column(name = "start_point")
    private String start_point;

    @Column(name = "dest_office")
    private String dest_office;

    @Column(name = "meeting_point_desc")
    private String meeting_point_desc;

    @Column(name = "aviable_seats")
    private int aviable_seats;

    @Column(name = "price")
    private float price;
    

    @ManyToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    public Trip() {
    }


    public Trip(Date departure_date, Time departure_time, String start_point, String dest_office, String meeting_point_desc, int aviable_seats, float price, Vehicle vehicle, User user) {
        this.departure_date = departure_date;
        this.departure_time = departure_time;
        this.start_point = start_point;
        this.dest_office = dest_office;
        this.meeting_point_desc = meeting_point_desc;
        this.aviable_seats = aviable_seats;
        this.price = price;
        this.vehicle = vehicle;
        this.user = user;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDeparture_date() {
        return this.departure_date;
    }

    public void setDeparture_date(java.sql.Date departure_date) {
        this.departure_date = departure_date;
    }

    public void setDeparture_date(String departureDateString) {
        this.departure_date = Date.valueOf(departureDateString);
    }

    public Time getDeparture_time() {
        return this.departure_time;
    }

    public void setDeparture_time(Time departure_time) {
        this.departure_time = departure_time;
    }

    public void setDeparture_time(String departureTimeString) {
       LocalTime time = LocalTime.parse(departureTimeString);
       this.departure_time = Time.valueOf(time);
    }

    public String getStart_point() {
        return this.start_point;
    }

    public void setStart_point(String start_point) {
        this.start_point = start_point;
    }

    public String getDest_office() {
        return this.dest_office;
    }

    public void setDest_office(String dest_office) {
        this.dest_office = dest_office;
    }

    public String getMeeting_point_desc() {
        return this.meeting_point_desc;
    }

    public void setMeeting_point_desc(String meeting_point_desc) {
        this.meeting_point_desc = meeting_point_desc;
    }

    public int getAviable_seats() {
        return this.aviable_seats;
    }

    public void setAviable_seats(int aviable_seats) {
        this.aviable_seats = aviable_seats;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}