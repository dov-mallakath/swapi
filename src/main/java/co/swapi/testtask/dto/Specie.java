package co.swapi.testtask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Specie {

    @JsonProperty("average_height")
    private String averageHeight;
    @JsonProperty("average_lifespan")
    private String averageLifespan;
    private String classification;
    private String created;
    private String designation;
    private String edited;
    @JsonProperty("eye_colors")
    private String eyeColors;
    @JsonProperty("hair_colors")
    private String hairColors;
    private String homeworld;
    private String language;
    private String name;
    private List<String> people;
    private List<String> films;
    @JsonProperty("skin_colors")
    private String skinColors;
    private String url;

    public String getAverageHeight() {
        return averageHeight;
    }

    public String getAverageLifespan() {
        return averageLifespan;
    }

    public String getClassification() {
        return classification;
    }

    public String getCreated() {
        return created;
    }

    public String getDesignation() {
        return designation;
    }

    public String getEdited() {
        return edited;
    }

    public String getEyeColors() {
        return eyeColors;
    }

    public String getHairColors() {
        return hairColors;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public String getLanguage() {
        return language;
    }

    public String getName() {
        return name;
    }

    public List<String> getPeople() {
        return people;
    }

    public List<String> getFilms() {
        return films;
    }

    public String getSkinColors() {
        return skinColors;
    }

    public String getUrl() {
        return url;
    }
}
