package co.swapi.testtask.dto;

import lombok.Data;

import java.util.List;

@Data
public class Planets extends ResponseWrapper {
    private List<Planet> results;

    public List<Planet> getResults() {
        return results;
    }
}
