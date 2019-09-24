package com.shubhanuj.springboot.demo.model;

public class WeatherCurrentDay {
	
    private String sunrise;//: weather.sys.sunrise,
    private String sunset;//: weather.sys.sunset,
    private String time;//: weather.dt,
    private String city;//: weather.name,
    private String weatherDesc;//: weather.weather[0].main,
    private String weatherText;//: weather.weather[0].description,
    private String temp;//: weather.main.temp,
    private String temp_min;//: weather.main.temp_min,
    private String temp_max;//: weather.main.temp_max,
    private String humidity;//: weather.main.humidity,
    private String icon;//: 'https://openweathermap.org/img/wn/' + weather.weather[0].icon + '@2x.png'
	/**
	 * @return the sunrise
	 */
	public String getSunrise() {
		return sunrise;
	}
	/**
	 * @param sunrise the sunrise to set
	 */
	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}
	/**
	 * @return the sunset
	 */
	public String getSunset() {
		return sunset;
	}
	/**
	 * @param sunset the sunset to set
	 */
	public void setSunset(String sunset) {
		this.sunset = sunset;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the weatherDesc
	 */
	public String getWeatherDesc() {
		return weatherDesc;
	}
	/**
	 * @param weatherDesc the weatherDesc to set
	 */
	public void setWeatherDesc(String weatherDesc) {
		this.weatherDesc = weatherDesc;
	}
	/**
	 * @return the weatherText
	 */
	public String getWeatherText() {
		return weatherText;
	}
	/**
	 * @param weatherText the weatherText to set
	 */
	public void setWeatherText(String weatherText) {
		this.weatherText = weatherText;
	}
	/**
	 * @return the temp
	 */
	public String getTemp() {
		return temp;
	}
	/**
	 * @param temp the temp to set
	 */
	public void setTemp(String temp) {
		this.temp = temp;
	}
	/**
	 * @return the temp_min
	 */
	public String getTemp_min() {
		return temp_min;
	}
	/**
	 * @param temp_min the temp_min to set
	 */
	public void setTemp_min(String temp_min) {
		this.temp_min = temp_min;
	}
	/**
	 * @return the temp_max
	 */
	public String getTemp_max() {
		return temp_max;
	}
	/**
	 * @param temp_max the temp_max to set
	 */
	public void setTemp_max(String temp_max) {
		this.temp_max = temp_max;
	}
	/**
	 * @return the humidity
	 */
	public String getHumidity() {
		return humidity;
	}
	/**
	 * @param humidity the humidity to set
	 */
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

}
