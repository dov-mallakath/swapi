package co.swapi.testtask.dto;

import java.util.List;

public class Species extends ResponseWrapper {
    private List<Specie> results;

    public List<Specie> getResults() {
        return results;
    }
}
