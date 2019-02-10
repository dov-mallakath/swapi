package co.swapi.testtask


import spock.lang.Shared
import spock.lang.Specification

class BaseTest extends Specification {

    @Shared
    def swapiService

    def setupSpec() {
        swapiService = new SwapiService()
    }

}
