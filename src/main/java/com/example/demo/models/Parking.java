package com.example.demo.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parking")
public class Parking {

    public Parking(int rack, List<Car> carList) {
        this.rack = rack;
        this.carList = carList;

    }

    public Parking() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int rack;

    @ManyToMany
    @JoinTable(name = "ParkCar",
            joinColumns = @JoinColumn(name = "parking_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id"))
    private List<Car> carList;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public int getRack() {
        return rack;
    }

    public void setRack(int rack) {
        this.rack = rack;
    }



    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }


}
