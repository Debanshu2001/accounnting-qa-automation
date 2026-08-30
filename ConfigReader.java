package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    public static Properties loadProperties() {
        if (prop == null) {
            prop = new Properties();
            try {
                FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
                prop.load(fis);
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException("Failed to load config.properties: " + e.getMessage());
            }
        }
        return prop;
    }

    public static String get(String key) {
        return loadProperties().getProperty(key);
    }
}
