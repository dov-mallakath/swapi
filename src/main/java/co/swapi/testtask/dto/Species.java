package co.swapi.testtask.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Species extends ResponseWrapper {

    private List<Specie> results;

}
