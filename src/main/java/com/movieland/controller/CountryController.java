package com.movieland.controller;

import com.movieland.persistance.entity.Country;
import com.movieland.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    CountryService countryService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Country> getAllCountry() {
        log.info("Sending request to get all country");
        return countryService.getAllCountry();
    }
}