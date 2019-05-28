package org.cnu.realcoding.weathercrawler.api;

import org.cnu.realcoding.weathercrawler.domain.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherMapApiClient {
    @Autowired
    private RestTemplate restTemplate;

    private final String apiKey = "ee62790f69f465b25ebf3f3097aa8af5";
    private final String currentWeatherUri = "http://api.openweathermap.org/data/2.5/weather?q={cityName}&APPID={apiKey}";

    public CurrentWeather getCurrentWeather(String cityName) {
        CurrentWeather currentWeather = restTemplate.exchange(currentWeatherUri, HttpMethod.GET, null, CurrentWeather.class, cityName, apiKey)
                .getBody();
        return currentWeather;
    }
}
