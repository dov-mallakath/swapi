package co.swapi.testtask

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

import java.lang.invoke.MethodHandles

class PropertiesCache {

    private static final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass())
    private static final PropertiesCache INSTANCE = new PropertiesCache()
    private final Properties configProp = new Properties()

    private PropertiesCache() {
        LOG.info("Read all properties from file")
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("test.properties")
        try {
            configProp.load(inputStream)
        } catch (IOException e) {
            LOG.error("Can't read all properties from file. Exception: " + e)
        }
    }

    def static getTestProperty(String key) {
        return INSTANCE.configProp.getProperty(key)
    }

}
