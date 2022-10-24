package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
public class User {

    public User(String login, String password, int phone, float checks, boolean accesss) {
        this.login = login;
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
    private String login;


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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
