package co.swapi.testtask.dto

import com.fasterxml.jackson.annotation.JsonProperty

class Planet {

    def name
    @JsonProperty("rotation_period")
    def rotationPeriod
    @JsonProperty("orbital_period")
    def orbitalPeriod
    def diameter
    def climate
    def gravity
    def terrain
    @JsonProperty("surface_water")
    def surfaceWater
    def population
    List<String> residents
    def films
    def created
    def edited
    def url

}
