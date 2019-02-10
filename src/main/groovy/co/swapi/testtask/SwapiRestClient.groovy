package co.swapi.testtask

import io.restassured.response.Response

class SwapiRestClient extends BaseClient {

    private static final String RESOURCE_ENDPOINT = "%s/"
    private static final String RESOURCE_ENDPOINT_ID = "%s/%s/"
    private static final String SEARCH_RESOURCE_ENDPOINT = "%s/?search=%s"
    private static final String PAGE_ENDPOINT = "%s/?page=%s"

    Response getFromResource(Endpoints endpoint) {
        return when().get(String.format(RESOURCE_ENDPOINT, endpoint.getEndpoint()))
    }

    Response getPageFromResource(Endpoints endpoint, String pageNumber) {
        return when().get(String.format(PAGE_ENDPOINT, endpoint.getEndpoint(), pageNumber))
    }

    Response getResourceById(Endpoints endpoint, String planetId) {
        return when().get(String.format(RESOURCE_ENDPOINT_ID, endpoint.getEndpoint(), planetId))
    }

    Response searchInTheResource(Endpoints endpoint, String searchRequest) {
        return when().get(String.format(SEARCH_RESOURCE_ENDPOINT, endpoint.getEndpoint(), searchRequest))
    }

}
