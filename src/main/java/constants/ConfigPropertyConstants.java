package constants;

import utilities.ConfigReader;

public class ConfigPropertyConstants {

    private static ConfigReader configReader = new ConfigReader();

    // Constants for configuration properties
    public static final String BROWSER = configReader.getProperty("browser"); // Constant for browser configuration
}
