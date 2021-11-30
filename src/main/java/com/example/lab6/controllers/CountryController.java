package com.example.lab6.controllers;


import com.example.lab6.models.Country;
import com.example.lab6.models.Task;
import com.example.lab6.repositories.CountryRepository;
import com.example.lab6.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("countryController")
@RequestMapping("/country")
public class CountryController {

    public final CountryRepository countryRepository;

    public CountryController(@Qualifier("countries") CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @RequestMapping("/list")
    @ResponseBody
    public String countryList() {
        StringBuilder response = new StringBuilder();

        for (Country country : countryRepository.findAll()) {
            response.append(country).append("<br>");
        }

        return response.toString();
    }

    @RequestMapping(value="/area/min/{min}/max/{max}", method = RequestMethod.GET)
    @ResponseBody
    public String findByCostBetween(@PathVariable Double min, @PathVariable Double max){

        StringBuilder response = new StringBuilder();

        List<Country> countries = countryRepository.findAllBySurfaceAreaBetween(min, max);

        for (Country country :countries) {
            response.append(country).append("<br>");
        }

        return response.toString();
    }


}
