package co.swapi.testtask;

import co.swapi.testtask.dto.Planet;
import org.testng.annotations.Test;

import static co.swapi.testtask.utils.SwapiHelper.getEntitiesFromUrls;
import static java.util.Collections.singletonList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class SearchInPlanetsTest extends BaseTest {

    private static final String PEOPLE_ID = "3";
    private static final String EXPECTED_PLANET_NAME = "Naboo";

    @Test
    public void shouldFindPlanetForPeopleWithId3() {
        String planetUrl = swapiService.getPeopleById(PEOPLE_ID).getHomeworld();
        Planet planetFromPeople = getEntitiesFromUrls(Planet.class, Endpoints.PLANETS, singletonList(planetUrl))
                .stream()
                .findFirst()
                .orElse(new Planet());
        assertThat(planetUrl, notNullValue());
        assertThat(planetFromPeople.getName(), equalTo(EXPECTED_PLANET_NAME));
    }

}
