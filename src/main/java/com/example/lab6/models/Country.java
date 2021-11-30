package com.example.lab6.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="country")
public class Country {

    @Id
    @Column
    private String code;

    @Column
    private String name;

    @Column
    private String continent;

    @Column(name = "SurfaceArea")
    private Double surfaceArea;


    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public Double getSurfaceArea() {
        return surfaceArea;
    }

    @Override
    public String toString() {
        return "Encja Kraj { kod=" + code + ", " + "name= " + name +
                ", continent=" + continent + "}";
    }
}

