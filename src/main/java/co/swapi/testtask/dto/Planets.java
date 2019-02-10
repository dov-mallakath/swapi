package co.swapi.testtask.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Planets extends ResponseWrapper {

    private List<Planet> results;

}
