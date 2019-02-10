package co.swapi.testtask.dto

import com.fasterxml.jackson.annotation.JsonProperty

class Specie {

    @JsonProperty("average_height")
    def averageHeight
    @JsonProperty("average_lifespan")
    def averageLifespan
    def classification
    def created
    def designation
    def edited
    @JsonProperty("eye_colors")
    def eyeColors
    @JsonProperty("hair_colors")
    def hairColors
    def homeworld
    def language
    def name
    List<String> people
    List<String> films
    @JsonProperty("skin_colors")
    def skinColors
    def url

}
