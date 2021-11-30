package com.example.lab6.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "country")
public class Country {

    @Id
    @Column(name = "Code")
    private String code;

    @Column(name = "Name")
    private String name;

    @Column(name = "Continent")
    private String continent;

    @Column(name = "SurfaceArea")
    private Double surfaceArea;

    @Column(name = "Population")
    private Long population;



    @Override
    public String toString() {
        return "Encja Kraj { " +
                "kod=" + code + ", " +
                "name= " + name + ", " +
                "continent=" + continent + "," +
                "Powierzchnia= " + surfaceArea + ", " +
                "Populacja= " + population + ", " +
                " }";
    }
}

