package com.example.lab6.repositories;

import com.example.lab6.models.Country;
import com.example.lab6.models.Task;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("countries")
public interface CountryRepository extends CrudRepository<Country, Long> {

    List<Country> findAllByContinent(String continent);

    List<Country> findAllBySurfaceAreaBetween(Double cost, Double cost2);

    List<Country> findAllByPopulationLessThan(Long population);
}
