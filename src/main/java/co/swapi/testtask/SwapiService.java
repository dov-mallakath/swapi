package co.swapi.testtask;

import co.swapi.testtask.dto.People;
import co.swapi.testtask.dto.Planet;
import co.swapi.testtask.dto.Planets;
import co.swapi.testtask.dto.Species;

import static org.apache.http.HttpStatus.SC_OK;

public class SwapiService {

    private SwapiRestClient swapiRestClient;

    SwapiService() {
        swapiRestClient = new SwapiRestClient();
    }

    public Planets getPlanets() {
        return swapiRestClient.getAllFromResource(Endpoints.PLANETS)
                .then()
                .statusCode(SC_OK)
                .extract()
                .body()
                .as(Planets.class);
    }

    public Planet getPlanetById(String planetId) {
        return swapiRestClient.getResourceById(Endpoints.PLANETS, planetId)
                .then()
                .statusCode(SC_OK)
                .extract()
                .body()
                .as(Planet.class);
    }

    public People getPeopleById(String peopleId) {
        return swapiRestClient.getResourceById(Endpoints.PEOPLE, peopleId)
                .then()
                .statusCode(SC_OK)
                .extract()
                .body()
                .as(People.class);
    }

    public Planets searchInPlanets(String searchRequest) {
        return swapiRestClient.searchInTheResource(Endpoints.PLANETS, searchRequest)
                .then()
                .statusCode(SC_OK)
                .extract()
                .body()
                .as(Planets.class);
    }

    public Species searchInSpecies(String searchRequest) {
        return swapiRestClient.searchInTheResource(Endpoints.SPECIES, searchRequest)
                .then()
                .statusCode(SC_OK)
                .extract()
                .body()
                .as(Species.class);
    }

}
