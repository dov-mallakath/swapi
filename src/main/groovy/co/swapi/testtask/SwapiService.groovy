package co.swapi.testtask

import co.swapi.testtask.dto.People
import co.swapi.testtask.dto.Planet
import co.swapi.testtask.dto.Planets
import co.swapi.testtask.dto.Species

import static co.swapi.testtask.utils.SwapiHelper.getMatchedDigitPatternFromUrl
import static org.apache.http.HttpStatus.SC_OK

class SwapiService {

    private SwapiRestClient swapiRestClient

    SwapiService() {
        swapiRestClient = new SwapiRestClient()
    }

    def getPlanets() {
        return swapiRestClient.getFromResource(Endpoints.PLANETS)
                .then()
                .statusCode(SC_OK)
                .extract()
                .body()
                .as(Planets.class)
    }

    def getPlanets(String pageNumber) {
        return swapiRestClient.getPageFromResource(Endpoints.PLANETS, pageNumber)
                .then()
                .statusCode(SC_OK)
                .extract()
                .body()
                .as(Planets.class)
    }

    def getAllPlanets() {
        def planets = getPlanets()
        def allPlanets = planets.getResults()
        while (planets.getNext() != null) {
            planets = getPlanets(getMatchedDigitPatternFromUrl((String) planets.getNext()))
            allPlanets.addAll(planets.getResults())
        }
        return allPlanets
    }

    def getPlanetById(String planetId) {
        return swapiRestClient.getResourceById(Endpoints.PLANETS, planetId)
                .then()
                .statusCode(SC_OK)
                .extract()
                .body()
                .as(Planet.class)
    }

    def getPeopleById(String peopleId) {
        return swapiRestClient.getResourceById(Endpoints.PEOPLE, peopleId)
                .then()
                .statusCode(SC_OK)
                .extract()
                .body()
                .as(People.class)
    }

    def searchInPlanets(String searchRequest) {
        return swapiRestClient.searchInTheResource(Endpoints.PLANETS, searchRequest)
                .then()
                .statusCode(SC_OK)
                .extract()
                .body()
                .as(Planets.class)
    }

    def searchInSpecies(String searchRequest) {
        return swapiRestClient.searchInTheResource(Endpoints.SPECIES, searchRequest)
                .then()
                .statusCode(SC_OK)
                .extract()
                .body()
                .as(Species.class)
    }

}
