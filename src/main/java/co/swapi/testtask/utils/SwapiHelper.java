package co.swapi.testtask.utils;

import co.swapi.testtask.Endpoints;
import co.swapi.testtask.SwapiRestClient;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;
import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.http.HttpStatus.SC_OK;

public class SwapiHelper {

    public static <T> List<T> getEntitiesFromUrls(Class<T> entityClassName, Endpoints endpoint, List<String> entityUrls) {
        Pattern pattern = Pattern.compile("-?\\d+");
        return ofNullable(entityUrls).orElse(singletonList(EMPTY))
                .stream()
                .filter(Objects::nonNull)
                .filter(entityUrl -> pattern.matcher(entityUrl).find())
                .map(entityUrl -> {
                    Matcher matcher = pattern.matcher(entityUrl);
                    matcher.find();
                    return new SwapiRestClient()
                            .getResourceById(endpoint, matcher.group())
                            .then()
                            .statusCode(SC_OK)
                            .extract()
                            .as(entityClassName);
                })
                .collect(Collectors.toList());
    }

}
