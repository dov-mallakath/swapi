package co.swapi.testtask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.util.Properties;

class PropertiesCache {

    private static final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private static final PropertiesCache INSTANCE = new PropertiesCache();
    private final Properties configProp = new Properties();

    private PropertiesCache() {
        LOG.info("Read all properties from file");
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("test.properties");
        try {
            configProp.load(in);
        } catch (IOException e) {
            LOG.error("Can't read all properties from file. Exception: " + e);
        }
    }

    static String getProperty(String key) {
        return INSTANCE.configProp.getProperty(key);
    }

}
