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

}
