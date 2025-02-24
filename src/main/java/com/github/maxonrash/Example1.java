package com.github.maxonrash;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.maxonrash.exception.CallPerMinuteExceededException;
import com.github.maxonrash.exception.CityWithThisNameIsNotFoundException;
import com.github.maxonrash.exception.InternalErrorException;
import com.github.maxonrash.exception.InvalidApiKeyException;
import com.github.maxonrash.service.GetCurrentWeatherService;
import com.github.maxonrash.service.GetGeocodingService;

/**
 * Samples to show that storage holds only 10 cities at a time and replaces the oldest one
 * <p> Final JSON strings can be seen in logs.
 */
public class Example1 {
    public static void main(String[] args) throws CityWithThisNameIsNotFoundException, CallPerMinuteExceededException, InternalErrorException, InvalidApiKeyException, JsonProcessingException {
        var sdk1 = CurrentWeatherSDK.create(PropsProvider.getAppProps().getProperty("apikey1"), Type.ON_DEMAND, GetGeocodingService.DEFAULT_SERVICE, GetCurrentWeatherService.DEFAULT_SERVICE);
        // creating an instance with the same API key will give the link to existent one
        var sdk2 = CurrentWeatherSDK.create(PropsProvider.getAppProps().getProperty("apikey1"), Type.ON_DEMAND, GetGeocodingService.DEFAULT_SERVICE, GetCurrentWeatherService.DEFAULT_SERVICE);
        System.out.println("sdk1 and sdk2 comparison: " + (sdk1 == sdk2));
        sdk1.retrieveCurrentWeatherJSON("Moscow");
        sdk1.retrieveCurrentWeatherJSON("Berlin");
        sdk1.retrieveCurrentWeatherJSON("Zocca");
        sdk1.retrieveCurrentWeatherJSON("Toronto");
        sdk1.retrieveCurrentWeatherJSON("Rome");
        sdk1.retrieveCurrentWeatherJSON("Khabarovsk");
        sdk1.retrieveCurrentWeatherJSON("Rostov_na_donu");
        sdk1.retrieveCurrentWeatherJSON("Almaty");
        System.out.println("\r\n Takes info about \"Almaty\" from storage here (if it is up-to-date) : \r\n");
        sdk1.retrieveCurrentWeatherJSON("Almaty");
        sdk1.retrieveCurrentWeatherJSON("Kursk");
        sdk1.retrieveCurrentWeatherJSON("Tokyo");
        sdk1.retrieveCurrentWeatherJSON("Los-Angeles");
        System.out.println("\r\n Info about \"Moscow\" was removed with last call (11th city), so new request to API is sent: \r\n");
        sdk1.retrieveCurrentWeatherJSON("Moscow");

    }
}