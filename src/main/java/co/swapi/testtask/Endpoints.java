package co.swapi.testtask;

public enum Endpoints {

    PEOPLE("people"),
    PLANETS("planets"),
    SPECIES("species");

    private String endpoint;

    Endpoints(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }

}
