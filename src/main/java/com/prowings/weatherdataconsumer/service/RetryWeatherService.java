package com.prowings.weatherdataconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prowings.weatherdataconsumer.model.WeatherData;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class RetryWeatherService {
	
	@Autowired
    private WeatherService weatherService;

    @Retry(name = "weatherService", fallbackMethod = "fallback")
    public WeatherData callWeatherService(String city) {
        return weatherService.getWeatherData(city);
    }

    public WeatherData fallback(String city, Throwable t) {
        WeatherData fallbackData = new WeatherData();
        
        log.info("in fallback method of climate retry!!");
        
        System.out.println("Weather service is temporarily unavailable----- retry!!!");
        fallbackData.setCity(city);
        fallbackData.setDescription("No data available");
        fallbackData.setTemperature(0.0);
        fallbackData.setHumidity(0.0);
        fallbackData.setWindSpeed(0.0);
        return fallbackData;
    }

}
