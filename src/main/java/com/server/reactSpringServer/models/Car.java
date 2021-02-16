package com.server.reactSpringServer.models;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String model;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private User user;


    public Car() {
    }

    public Car(String model) {
        this.model = model;
    }

    public Car(String model, User user) {
        this.model = model;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
