package com.example.lab6.models;

import javax.persistence.*;

@Entity
public class Task {
    @GeneratedValue
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    @Lob
    private String description;

    @Column
    private Double cost;

    @Column
    private Boolean isDone = false;

    public Task() {
        this.cost = 2000.0;
        this.name = "Zadanie";
        this.description = "Zadanie do wykonania";
    }

    @Override
    public String toString() {
        return "Encja Zadanie{ id=" + id + ", " + name + ", " + description +
                ", koszt=" + cost + ", wykonane=" + isDone + "}";
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }
}
