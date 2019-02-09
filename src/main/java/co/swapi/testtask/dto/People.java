package co.swapi.testtask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class People {

    @JsonProperty("birth_year")
    private String birthYear;
    @JsonProperty("eye_color")
    private String eyeColor;
    private List<String> films;
    private String gender;
    @JsonProperty("hair_color")
    private String hairColor;
    private String height;
    private String homeworld;
    private String mass;
    private String name;
    @JsonProperty("skin_color")
    private String skinColor;
    private String created;
    private String edited;
    private List<String> species;
    private List<String> starships;
    private String url;
    private List<String> vehicles;

    public String getBirthYear() {
        return birthYear;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public List<String> getFilms() {
        return films;
    }

    public String getGender() {
        return gender;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getHeight() {
        return height;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public String getMass() {
        return mass;
    }

    public String getName() {
        return name;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public String getCreated() {
        return created;
    }

    public String getEdited() {
        return edited;
    }

    public List<String> getSpecies() {
        return species;
    }

    public List<String> getStarships() {
        return starships;
    }

    public String getUrl() {
        return url;
    }

    public List<String> getVehicles() {
        return vehicles;
    }
}
