package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties; // Properties object to store configuration properties

    public ConfigReader() { // Constructor to initialize the Properties object
        properties = new Properties(); // Initializing the Properties object
        try {
            FileInputStream inputStream = new FileInputStream(
                    System.getProperty("user.dir") + "/src/main/resources/propertyFiles/config.properties"); // Creating a FileInputStream to read the config.properties file
            properties.load(inputStream); // Loading properties from the input stream into the Properties object
            inputStream.close(); // Closing the input stream
        } catch (IOException e) {
            e.printStackTrace(); // Handling IOException
        }
    }

    public static synchronized String getProperty(String key) { // Method to retrieve a property value by key, synchronized for thread safety
        return properties.getProperty(key); // Returning the value associated with the specified key
    }
}
