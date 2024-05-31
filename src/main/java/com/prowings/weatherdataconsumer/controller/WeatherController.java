package com.prowings.weatherdataconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.weatherdataconsumer.model.WeatherData;
import com.prowings.weatherdataconsumer.service.RetryWeatherService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class WeatherController {
	
	@Autowired
    private RetryWeatherService retryWeatherService;

    @GetMapping("/fetchWeather")
    public WeatherData fetchWeather(@RequestParam String city) {
    	
    	log.info("request received to get city from climate api...");
    	
        return retryWeatherService.callWeatherService(city);
        
    }
	


}
