package com.shubhanuj.springboot.demo.service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shubhanuj.springboot.demo.constants.WeatherConstants;

@Service
public class GetWeatherService {

	String measurementUnit = WeatherConstants.WEATHER_API_MEASUREMENT_UNIT;
	String apiKey = WeatherConstants.WEATHER_API_KEY;

	public JSONObject getCurrentWeather(String latitude, String longitude) {

		JSONObject weather = null;

		RestTemplate restTemplate = new RestTemplate();
		String URL = "https://api.openweathermap.org/data/2.5/weather?units=" + measurementUnit + "&lat=" + latitude
				+ "&lon=" + longitude + "&appid=" + apiKey;
		System.out.println(URL);

		Long startTime = System.currentTimeMillis();
		weather = new JSONObject(restTemplate.getForObject(URL, String.class));
		Long endTime = System.currentTimeMillis();

		System.out.println("API call time: " + (endTime - startTime));

		return weather;
	}

public JSONObject getForecastWeather(String latitude, String longitude) {
		
		JSONObject weather=null;
		Map<String, JSONArray> forecastWeatherObj= null;
		JSONArray weatherObjArray =null;
		
		RestTemplate restTemplate = new RestTemplate();
		String URL = "https://api.openweathermap.org/data/2.5/forecast?units=" + measurementUnit 
				+ "&lat=" + latitude + "&lon=" + longitude
				+ "&appid=" + apiKey;
		System.out.println(URL); 
		
		Long startTime=System.currentTimeMillis();
		weather = new JSONObject(restTemplate.getForObject(URL, String.class));
		Long endTime=System.currentTimeMillis();
		
		Long timeOffset= weather.getJSONObject("city").getLong("timezone");
		
		JSONArray weatherForecast=weather.getJSONArray("list");
		forecastWeatherObj=new TreeMap<String, JSONArray>();
		
		for(Object weatherObj: weatherForecast) {
			Integer dateGMT= ((JSONObject) weatherObj).getInt("dt");
			Long dateLocal= dateGMT + timeOffset;
			Long dateLocalMS=dateLocal *1000;	
			String dateString=DateTimeFormatter.ofPattern("yyy/MM/dd").
					format(Instant.ofEpochMilli(dateLocalMS).atZone(ZoneId.systemDefault()).toLocalDateTime());
			
			if(forecastWeatherObj.containsKey(dateString)) {
				forecastWeatherObj.get(dateString).put(weatherObj);
			}else {
				weatherObjArray=new JSONArray();
				weatherObjArray.put(weatherObj);
				forecastWeatherObj.put(dateString, weatherObjArray);
			}

			
		}
		
		System.out.println("API call time: "+ (endTime-startTime));

		return new JSONObject(forecastWeatherObj);
	}

}
