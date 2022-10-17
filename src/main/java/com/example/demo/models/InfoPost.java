package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InfoPost {

    public InfoPost(String shapka, String name, String info, String maintext, int stat) {

        this.shapka = shapka;
        this.name = name;
        this.info = info;
        this.maintext = maintext;
        this.stat = stat;
    }

    public InfoPost() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String shapka, name, info, maintext;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getMaintext() {
        return maintext;
    }

    public void setMaintext(String maintext) {
        this.maintext = maintext;
    }

    public int getViews() {
        return stat;
    }

    public void setViews(int stat) {
        this.stat = stat;
    }

}
