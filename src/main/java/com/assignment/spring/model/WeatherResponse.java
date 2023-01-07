
package com.assignment.spring.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "coord",
    "weather",
    "base",
    "main",
    "visibility",
    "wind",
    "clouds",
    "dt",
    "sys",
    "id",
    "name",
    "cod"
})
public class WeatherResponse {

    @JsonProperty("coord")
    private CoordDto coord;
    @JsonProperty("weather")
    private List<WeatherDto> weather = null;
    @JsonProperty("base")
    private String base;
    @JsonProperty("main")
    private MainDto main;
    @JsonProperty("visibility")
    private Integer visibility;
    @JsonProperty("wind")
    private WindDto wind;
    @JsonProperty("clouds")
    private CloudsDto clouds;
    @JsonProperty("dt")
    private Integer dt;
    @JsonProperty("sys")
    private SysDto sys;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("cod")
    private Integer cod;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("coord")
    public CoordDto getCoord() {
        return coord;
    }

    @JsonProperty("coord")
    public void setCoord(CoordDto coord) {
        this.coord = coord;
    }

    @JsonProperty("weather")
    public List<WeatherDto> getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(List<WeatherDto> weather) {
        this.weather = weather;
    }

    @JsonProperty("base")
    public String getBase() {
        return base;
    }

    @JsonProperty("base")
    public void setBase(String base) {
        this.base = base;
    }

    @JsonProperty("main")
    public MainDto getMain() {
        return main;
    }

    @JsonProperty("main")
    public void setMain(MainDto main) {
        this.main = main;
    }

    @JsonProperty("visibility")
    public Integer getVisibility() {
        return visibility;
    }

    @JsonProperty("visibility")
    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    @JsonProperty("wind")
    public WindDto getWind() {
        return wind;
    }

    @JsonProperty("wind")
    public void setWind(WindDto wind) {
        this.wind = wind;
    }

    @JsonProperty("clouds")
    public CloudsDto getClouds() {
        return clouds;
    }

    @JsonProperty("clouds")
    public void setClouds(CloudsDto clouds) {
        this.clouds = clouds;
    }

    @JsonProperty("dt")
    public Integer getDt() {
        return dt;
    }

    @JsonProperty("dt")
    public void setDt(Integer dt) {
        this.dt = dt;
    }

    @JsonProperty("sys")
    public SysDto getSys() {
        return sys;
    }

    @JsonProperty("sys")
    public void setSys(SysDto sys) {
        this.sys = sys;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("cod")
    public Integer getCod() {
        return cod;
    }

    @JsonProperty("cod")
    public void setCod(Integer cod) {
        this.cod = cod;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
