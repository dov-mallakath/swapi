package co.swapi.testtask

import co.swapi.testtask.dto.People
import spock.lang.Unroll

import java.util.stream.Collectors

import static co.swapi.testtask.utils.SwapiHelper.getEntitiesFromUrls

class SearchInSpeciesTest extends BaseTest {

    @Unroll
    def "should find all People from Species #searchRequest"() {
        given: 'expected People names for Species Droid'
        def expectedPeopleNames = Arrays.asList("C-3PO", "R2-D2", "R5-D4", "IG-88", "BB8")

        when: 'getting people urls from species, obtained by search parameter #searchRequest'
        def peopleFromSpeciesUrls = getAllPeopleUrlsFromSpecies(searchRequest.toString())
        and: 'getting People from people urls'
        def peopleFromSpecies = getEntitiesFromUrls(People.class, Endpoints.PEOPLE, peopleFromSpeciesUrls)

        then: 'people urls and People from urls should not be empty'
        assert !peopleFromSpeciesUrls.isEmpty()
        assert !peopleFromSpecies.isEmpty()
        and: 'People names from Species #searchRequest should be equal to expected names'
        assert peopleFromSpecies.stream().map({ people -> people.getName() }).collect(Collectors.toList()) == expectedPeopleNames

        where:
        searchRequest | _
        "droid"       | _
        "Droid"       | _
        "dro"         | _
    }

    def "should not find any Species for incorrect search"() {
        given: 'incorrect search request'
        def incorrectSearchRequest = "Droids"

        when: 'Searching Species with incorrect search request'
        def species = swapiService.searchInSpecies(incorrectSearchRequest).getResults()

        then: 'There should be no results'
        assert species.isEmpty()
    }

    private List<String> getAllPeopleUrlsFromSpecies(String searchRequest) {
        List<String> peopleFromSpeciesUrls = new ArrayList<>()
        swapiService.searchInSpecies(searchRequest).getResults()
                .stream()
                .filter({ specie -> !specie.getPeople().isEmpty() })
                .map({ peopleFromSpecies -> peopleFromSpecies.getPeople() })
                .collect(Collectors.toList())
                .forEach({ peopleFromSpecies -> peopleFromSpeciesUrls.addAll(peopleFromSpecies) })
        return peopleFromSpeciesUrls
    }

}
