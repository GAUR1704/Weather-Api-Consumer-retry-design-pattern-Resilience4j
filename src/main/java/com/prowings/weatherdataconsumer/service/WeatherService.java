package com.prowings.weatherdataconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prowings.weatherdataconsumer.model.WeatherData;

@Service
public class WeatherService {

	@Autowired
    private RestTemplate restTemplate;

    public WeatherData getWeatherData(String city) {
    	
        String url = "http://localhost:8080/weather?city=" + city;
        
        return restTemplate.getForObject(url, WeatherData.class);
    }
}
