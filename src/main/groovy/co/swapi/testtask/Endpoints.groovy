package co.swapi.testtask

enum Endpoints {

    PEOPLE("people"),
    PLANETS("planets"),
    SPECIES("species");

    private String endpoint

    Endpoints(String endpoint) {
        this.endpoint = endpoint
    }

    String getEndpoint() {
        return endpoint
    }

}
