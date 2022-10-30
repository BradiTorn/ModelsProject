package com.example.demo.models;

import javax.persistence.*;

@Entity
public class Garage {

    public Garage(int mesto, Car car) {

        this.mesto = mesto;
        this.car = car;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int mesto;

    @OneToOne(optional = true, mappedBy = "garage")
    private Car car;

    public Garage() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public int getMesto() {
        return mesto;
    }

    public void setMesto(int mesto) {
        this.mesto = mesto;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}
