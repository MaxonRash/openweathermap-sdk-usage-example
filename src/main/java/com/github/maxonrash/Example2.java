package com.github.maxonrash;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.maxonrash.exception.CallPerMinuteExceededException;
import com.github.maxonrash.exception.CityWithThisNameIsNotFoundException;
import com.github.maxonrash.exception.InternalErrorException;
import com.github.maxonrash.exception.InvalidApiKeyException;
import com.github.maxonrash.service.GetCurrentWeatherService;
import com.github.maxonrash.service.GetGeocodingService;

/**
 * Demonstrating POLLING type mode
 */
public class Example2 {
    public static void main(String[] args) throws CityWithThisNameIsNotFoundException, CallPerMinuteExceededException, InternalErrorException, InvalidApiKeyException, JsonProcessingException, InterruptedException {
        var sdk1 = CurrentWeatherSDK.create(PropsProvider.getAppProps().getProperty("apikey1"), Type.ON_DEMAND, GetGeocodingService.DEFAULT_SERVICE, GetCurrentWeatherService.DEFAULT_SERVICE);
        sdk1.retrieveCurrentWeatherJSON("Moscow");
        sdk1.retrieveCurrentWeatherJSON("Berlin");
        sdk1.retrieveCurrentWeatherJSON("Zocca");
        sdk1.retrieveCurrentWeatherJSON("Toronto");
        sdk1.retrieveCurrentWeatherJSON("Rome");
        sdk1.setCurrentModeType(Type.POLLING);
        System.out.println("\r\n Updates info about each city in storage as MODE was changed to POLLING (if it is not up-to-date) : \r\n");
        // You can uncomment next line to wait 10 minutes and see that all data in storage will be outdated and updated
        // Thread.sleep(600 * 1000);
        sdk1.retrieveCurrentWeatherJSON("Tokyo");
        System.out.println("\r\n Next call with same city will still update each city but take data from storage: \r\n");
        sdk1.retrieveCurrentWeatherJSON("Tokyo");
    }
}
