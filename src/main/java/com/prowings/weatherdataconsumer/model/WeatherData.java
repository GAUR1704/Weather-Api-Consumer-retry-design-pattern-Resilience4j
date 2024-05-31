package com.prowings.weatherdataconsumer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WeatherData {
	
    private String city;
    private String description;
    private double temperature;
    private double humidity;
    private double windSpeed;

}
