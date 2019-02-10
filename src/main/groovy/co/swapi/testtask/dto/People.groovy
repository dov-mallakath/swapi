package co.swapi.testtask.dto

import com.fasterxml.jackson.annotation.JsonProperty

class People {

    @JsonProperty("birth_year")
    def birthYear
    @JsonProperty("eye_color")
    def eyeColor
    def films
    def gender
    @JsonProperty("hair_color")
    def hairColor
    def height
    def homeworld
    def mass
    def name
    @JsonProperty("skin_color")
    def skinColor
    def created
    def edited
    def species
    def starships
    def url
    def vehicles

}
