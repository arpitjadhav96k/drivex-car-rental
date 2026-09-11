package com.drivex.backend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private double pricePerDay;

    private String type;

    private String availability;

    // Default constructor required by JPA
    public Car() {
    }

    // Parameterized constructor
    public Car(Integer id, String name, double pricePerDay,
           String type, String availability) {
        this.id = id;
        this.name = name;
        this.pricePerDay = pricePerDay;
        this.type = type;
        this.availability = availability;
    }

   public Integer getId() {
    return id;
   }

    public String getName() {
        return name;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public String getType() {
        return type;
    }

    public String getAvailability() {
        return availability;
    }

    public void setId(Integer id) {
    this.id = id;
     }

    public void setName(String name) {
        this.name = name;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}