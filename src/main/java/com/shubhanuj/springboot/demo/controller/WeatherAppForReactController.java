package com.shubhanuj.springboot.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shubhanuj.springboot.demo.constants.WeatherConstants;
import com.shubhanuj.springboot.demo.service.GetWeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherAppForReactController {

	@Autowired
	GetWeatherService getWeatherService;

	@GetMapping("getCurrentDayWeather")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCurrentDayWeather(HttpServletRequest request, HttpServletResponse response, @RequestParam("lat") String latitude, @RequestParam("long") String longitude) {
		JSONObject weather = null;
		Long startTime=System.currentTimeMillis();
		
		if (StringUtils.isBlank(latitude) || StringUtils.isBlank(longitude)) {
			throw new NullPointerException("Missing Parameter. \nLatitude: " + latitude + "\nLongitude:" + longitude);
		}

		weather = getWeatherService.getCurrentWeather(latitude, longitude);
		response.addHeader("Access-Control-Allow-Origin", WeatherConstants.REACT_CORS_HEADER);
		System.out.println(weather);
		Long endTime=System.currentTimeMillis();
		
		System.out.println("Rest call time: "+ (endTime-startTime));
		return weather.toString();

	}
	
	@GetMapping("getForecastWeather")
	@Produces(MediaType.APPLICATION_JSON)
	public String getForecastDayWeather(HttpServletRequest request, HttpServletResponse response, @RequestParam("lat") String latitude, @RequestParam("long") String longitude) {
		JSONObject weather = null;
		Long startTime=System.currentTimeMillis();
		
		if (StringUtils.isBlank(latitude) || StringUtils.isBlank(longitude)) {
			throw new NullPointerException("Missing Parameter. \nLatitude: " + latitude + "\nLongitude:" + longitude);
		}

		weather = getWeatherService.getForecastWeather(latitude, longitude);
		response.addHeader("Access-Control-Allow-Origin", WeatherConstants.REACT_CORS_HEADER);
		System.out.println(weather);
		Long endTime=System.currentTimeMillis();
		
		System.out.println("Rest call time: "+ (endTime-startTime));


		return weather.toString();

	}

}
