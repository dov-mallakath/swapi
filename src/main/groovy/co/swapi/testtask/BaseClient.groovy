package co.swapi.testtask

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.config.ObjectMapperConfig
import io.restassured.config.RestAssuredConfig
import io.restassured.filter.log.RequestLoggingFilter
import io.restassured.filter.log.ResponseLoggingFilter
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import spock.lang.Shared

import static io.restassured.RestAssured.given

class BaseClient {

    @Shared
    def spec
    @Shared
    def objectMapper

    BaseClient() {
        objectMapper = new ObjectMapper()
        RestAssured.config = RestAssuredConfig.config().objectMapperConfig(
                new ObjectMapperConfig().jackson2ObjectMapperFactory({ aClass, s ->
                    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
                }))

        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(PropertiesCache.getTestProperty("base.api.url"))
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build()
    }

    RequestSpecification when() {
        return given()
                .spec(spec)
                .when()
    }

}
