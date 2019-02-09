package co.swapi.testtask;

import io.restassured.response.Response;

public class SwapiRestClient extends BaseClient {

    private static final String RESOURCE_ENDPOINT = "%s/";
    private static final String RESOURCE_ENDPOINT_ID = "%s/%s/";
    private static final String SEARCH_RESOURCE_ENDPOINT = "%s/?search=%s";

    Response getAllFromResource(Endpoints endpoint) {
        return when().get(String.format(RESOURCE_ENDPOINT, endpoint.getEndpoint()));
    }

    public Response getResourceById(Endpoints endpoint, String planetId) {
        return when().get(String.format(RESOURCE_ENDPOINT_ID, endpoint.getEndpoint(), planetId));
    }

    Response searchInTheResource(Endpoints endpoint, String searchRequest) {
        return when().get(String.format(SEARCH_RESOURCE_ENDPOINT, endpoint.getEndpoint(), searchRequest));
    }

}
