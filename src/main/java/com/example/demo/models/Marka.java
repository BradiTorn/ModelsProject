package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class Marka {

    public Marka(String namemarka, Collection<Car> car ) {

        this.namemarka = namemarka;
        this.car = car;
    }

    public Marka() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String namemarka;



    @OneToMany(mappedBy = "marka", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<Car> car;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameMarka() {
        return namemarka;
    }

    public void setNameMarka(String namemarka) {
        this.namemarka = namemarka;
    }




    public Collection<Car> getCar() {
        return car;
    }

    public void setCar(Collection<Car> car) {
        this.car = car;
    }
}
