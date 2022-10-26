package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class InfoPost {

    public InfoPost(String shapka, String name, String inform, double maintext, int stat) {

        this.shapka = shapka;
        this.name = name;
        this.inform = inform;
        this.maintext = maintext;
        this.stat = stat;
    }

    public InfoPost() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 3, max = 20, message = "От 3 до 20 символов")
    private String shapka;


    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 2, max = 20, message = "От 2 до 20 символов")
    private String name;


    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 4, max = 30, message = "От 4 до 30 символов")
    private String inform;

    @DecimalMax("100000.0") @DecimalMin("0.0")
    private double maintext;

    @Positive(message = "Число должно быть положительным")
    private int stat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShapka() {
        return shapka;
    }

    public void setShapka(String shapka) {
        this.shapka = shapka;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInform() {
        return inform;
    }

    public void setInform(String inform) {
        this.inform = inform;
    }

    public double getMaintext() {
        return maintext;
    }

    public void setMaintext(double maintext) {
        this.maintext = maintext;
    }

    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }

}
