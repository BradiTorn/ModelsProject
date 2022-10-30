package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "car")
public class Car {

    public Car(int nomer, String namecar, Marka marka, Garage garage, List<Parking> parkingList) {

        this.nomer = nomer;
        this.namecar = namecar;
        this.marka = marka;
        this.garage = garage;
        this.parkingList = parkingList;
    }

    public Car() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int nomer;

    @NotNull(message = "Поле не может быть пустым")
    @Size(min = 1, max = 255, message = "От 1 до 255 символов")
    private String namecar;

    @ManyToOne(optional = true, cascade = CascadeType.DETACH)
    private Marka marka;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "garage_id")
    private Garage garage;

    @ManyToMany
    @JoinTable(name = "ParkCar",
            joinColumns = @JoinColumn(name = "car_id"), inverseJoinColumns = @JoinColumn(name = "parking_id"))
    private List<Parking> parkingList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNomer() {
        return nomer;
    }

    public void setNomer(int nomer) {
        this.nomer = nomer;
    }

    public String getNamecar() {
        return namecar;
    }

    public void setNamecar(String namecar) {
        this.namecar = namecar;
    }




    public Marka getMarka() {
        return marka;
    }

    public void setMarka(Marka marka) {
        this.marka = marka;
    }



    public Garage getGarage() { return garage; }

    public void setGarage(Garage garage) { this.garage = garage; }



    public List<Parking> getParkingList() {
        return parkingList;
    }

    public void setParkingList(List<Parking> parkingList) {
        this.parkingList = parkingList;
    }

}
