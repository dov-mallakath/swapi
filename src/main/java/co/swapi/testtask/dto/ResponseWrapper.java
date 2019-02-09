package co.swapi.testtask.dto;

import lombok.Data;

@Data
public class ResponseWrapper {

    private int count;
    private String next;
    private String previous;

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }
}
