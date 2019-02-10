package co.swapi.testtask

import co.swapi.testtask.dto.Planet

import java.util.stream.Collectors

import static co.swapi.testtask.utils.SwapiHelper.getEntitiesFromUrls
import static co.swapi.testtask.utils.SwapiHelper.getMatchedDigitPatternFromUrl
import static java.util.Collections.singletonList

class SearchInPlanetsTest extends BaseTest {

    private static final String PEOPLE_ID = "3"
    private static final String EXPECTED_PLANET_NAME = "Naboo"

    def "should find homeworld planet for people with id 3"() {
        given: 'People id is 3, expected Planet name is Naboo'

        when: 'getting homeworld for people by id 3'
        String planetUrl = swapiService.getPeopleById(PEOPLE_ID).getHomeworld()
        and: 'getting Planet from homeworld url'
        Planet planetFromPeople = getEntitiesFromUrls(Planet.class, Endpoints.PLANETS, singletonList(planetUrl))
                .stream()
                .findFirst()
                .orElse(new Planet())

        then: 'homeworld url should not be null'
        assert planetUrl != null
        and: 'Planet name should be equal to Naboo'
        assert planetFromPeople.getName() == EXPECTED_PLANET_NAME
    }

    def "should find all planets for people with id 3"() {
        given: 'People id is 3, expected Planet name is Naboo'

        when: 'getting all planets that have listed people with id 3'
        List<Planet> planetsForPeople = swapiService.getAllPlanets()
                .stream()
                .filter({ planet ->
            planet.getResidents()
                    .stream()
                    .anyMatch({ residentUrl -> getMatchedDigitPatternFromUrl((String) residentUrl) == PEOPLE_ID })
        })
                .collect(Collectors.toList())

        then: 'there should be only one result'
        assert planetsForPeople.size() == 1
        and: 'found planet name should be Naboo'
        assert planetsForPeople.stream().findFirst().orElse(new Planet()).getName() == EXPECTED_PLANET_NAME
    }

}
