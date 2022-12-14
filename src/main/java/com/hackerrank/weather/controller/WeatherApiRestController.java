package com.hackerrank.weather.controller;

import javax.validation.Valid;

import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.WeatherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/weather")
public class WeatherApiRestController {

  @Autowired
  WeatherRepository weatherRepository;

  @PostMapping
  public ResponseEntity create(@Valid @RequestBody Weather params) {

    Weather weather = new Weather(
      params.getDateRecorded(), 
      params.getCity(),
      params.getState(), 
      params.getLat(),
      params.getLon(),
      params.getTemperature()
    );

    return new ResponseEntity<Weather>(weatherRepository.save(weather), HttpStatus.CREATED);

  }


}
