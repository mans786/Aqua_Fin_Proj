package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class Constants {
    public static final int TIMEOUT = 45;
    public static final int POLLING = 1000;
    public static final int DRIVER_WAIT = 4000;
    public static final String PROPERTIES_NAME = "Myapp.properties";
    private static final Properties PROPS = loadProperties();

    private Constants() { }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("src/test/resources/" + PROPERTIES_NAME)) {
            properties.load(input);
            return properties;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to load " + PROPERTIES_NAME, e);
        }
    }

    public static String getApplicationUrl() { return PROPS.getProperty("ApplicationURL"); }
    public static String getBrowser() { return PROPS.getProperty("Browser", "chrome").toUpperCase(); }
    public static String getUsername() { return System.getProperty("username", PROPS.getProperty("Username", "john")); }
    public static String getPassword() { return System.getProperty("password", PROPS.getProperty("Password", "demo")); }
    public static String getProperty(String key) { return PROPS.getProperty(key, ""); }
}
