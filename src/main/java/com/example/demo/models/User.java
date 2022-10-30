package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
public class User {

    public User(String username, String password, int phone, float checks, boolean accesss) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.checks = checks;
        this.accesss = accesss;

    }

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 4, max = 20, message = "От 4 до 20 символов")
    private String username;


    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 8, max = 20, message = "От 8 до 16 символов")
    private String password;


    private int phone;


    @DecimalMax("10000.0") @DecimalMin("0.0")
    private float checks;



    private boolean accesss;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public float getChecks() {
        return checks;
    }

    public void setChecks(float checks) {
        this.checks = checks;
    }

    public boolean getAccesss() {
        return accesss;
    }

    public void setAccesss(boolean accesss) {
        this.accesss = accesss;
    }

}
