package co.swapi.testtask.dto;

import lombok.Data;

@Data
class ResponseWrapper {

    private int count;
    private String next;
    private String previous;

}
