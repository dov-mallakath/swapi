package co.swapi.testtask.utils

import co.swapi.testtask.Endpoints
import co.swapi.testtask.SwapiRestClient

import java.util.regex.Matcher
import java.util.regex.Pattern
import java.util.stream.Collectors

import static java.util.Collections.singletonList
import static java.util.Optional.ofNullable
import static org.apache.commons.lang3.StringUtils.EMPTY
import static org.apache.http.HttpStatus.SC_OK

class SwapiHelper {

    private static final Pattern DIGIT_PATTERN = Pattern.compile("-?\\d+")

    static String getMatchedDigitPatternFromUrl(String url) {
        Matcher matcher = DIGIT_PATTERN.matcher(url)
        matcher.find()
        return matcher.group()
    }

    static <T> List<T> getEntitiesFromUrls(Class<T> entityClassName, Endpoints endpoint, List<String> entityUrls) {
        return ofNullable(entityUrls).orElse(singletonList(EMPTY))
                .stream()
                .filter({ entityUrl -> DIGIT_PATTERN.matcher(entityUrl).find() })
                .map({ entityUrl ->
            new SwapiRestClient()
                    .getResourceById(endpoint, getMatchedDigitPatternFromUrl(entityUrl))
                    .then()
                    .statusCode(SC_OK)
                    .extract()
                    .as(entityClassName)
        })
                .collect(Collectors.toList())
    }

}
