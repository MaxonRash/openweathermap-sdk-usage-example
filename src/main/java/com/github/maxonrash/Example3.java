package com.github.maxonrash;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.maxonrash.exception.CallPerMinuteExceededException;
import com.github.maxonrash.exception.CityWithThisNameIsNotFoundException;
import com.github.maxonrash.exception.InternalErrorException;
import com.github.maxonrash.exception.InvalidApiKeyException;
import com.github.maxonrash.service.GetCurrentWeatherService;
import com.github.maxonrash.service.GetGeocodingService;

/**
 * Examples of exceptions
 */
public class Example3 {
    public static void main(String[] args) {
        var sdk1 = CurrentWeatherSDK.create(PropsProvider.getAppProps().getProperty("apikey1"), Type.ON_DEMAND, GetGeocodingService.DEFAULT_SERVICE, GetCurrentWeatherService.DEFAULT_SERVICE);
        // if apikey1 is not specified in app.properties ApiKeyIsNullOrEmptyException will be thrown
        try {
            sdk1.retrieveCurrentWeatherJSON("testtesttest");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (InvalidApiKeyException e) {
            System.out.println("API key is incorrect or not activated yet");;
        } catch (CallPerMinuteExceededException e) {
            System.out.println("You've exceeded the limit of requests per minute, try again later");;
        } catch (InternalErrorException e) {
            System.out.println("API server internal error (5** codes)");;
        } catch (CityWithThisNameIsNotFoundException e) {
            System.out.println("Specified city is not found"); // <----- this will be printed if the key is present and valid
        }
    }
}
