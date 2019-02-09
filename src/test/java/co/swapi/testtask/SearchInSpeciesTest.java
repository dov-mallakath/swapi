package co.swapi.testtask;

import co.swapi.testtask.dto.People;
import co.swapi.testtask.dto.Specie;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static co.swapi.testtask.utils.SwapiHelper.getEntitiesFromUrls;
import static java.util.Collections.emptyList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class SearchInSpeciesTest extends BaseTest {

    private static final String ASSERTION_FAILED_MESSAGE = "There are no people for species %s";
    private static final List<String> EXPECTED_PEOPLE_NAMES = Arrays.asList("C-3PO", "R2-D2", "R5-D4", "IG-88", "BB8");

    @DataProvider(name = "correct search requests")
    public Object[] correctSearchRequests() {
        return new Object[]{
                "droid",
                "Droid",
                "dro"};
    }

    @Test(dataProvider = "correct search requests")
    public void shouldFindAllPeopleFromSpeciesDroids(String searchRequest) {
        List<String> peopleFromSpeciesUrls = getAllPeopleUrlsFromSpecies(searchRequest);
        List<People> peopleFromSpecies = getEntitiesFromUrls(People.class, Endpoints.PEOPLE, peopleFromSpeciesUrls);
        assertThat(String.format(ASSERTION_FAILED_MESSAGE, searchRequest), peopleFromSpeciesUrls, is(not(emptyList())));
        assertThat(String.format(ASSERTION_FAILED_MESSAGE, searchRequest), peopleFromSpecies, is(not(emptyList())));
        assertThat(peopleFromSpecies.stream().map(People::getName).collect(Collectors.toList()), equalTo(EXPECTED_PEOPLE_NAMES));
    }

    @Test
    public void shouldNotFindAnySpeciesForIncorrectSearch() {
        String incorrectSearchRequest = "Droids";
        List<Specie> species = swapiService.searchInSpecies(incorrectSearchRequest).getResults();
        assertThat(species, is(emptyList()));
    }

    private List<String> getAllPeopleUrlsFromSpecies(String searchRequest) {
        List<String> peopleFromSpeciesUrls = new ArrayList<>();
        swapiService.searchInSpecies(searchRequest).getResults()
                .stream()
                .filter(specie -> !specie.getPeople().isEmpty())
                .map(Specie::getPeople)
                .collect(Collectors.toList())
                .forEach(peopleFromSpeciesUrls::addAll);
        return peopleFromSpeciesUrls;
    }

}
