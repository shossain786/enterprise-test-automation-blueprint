package framework.core.base.config;

import java.util.Properties;

public final class ConfigManager {

    private static final Properties properties = new Properties();

    static {
        properties.setProperty("browser", System.getProperty("browser", "chrome"));
        properties.setProperty("baseUrl", System.getProperty("baseUrl", "https://panjatan.netlify.app/"));
        properties.setProperty("headless", System.getProperty("headless", "false"));
        properties.setProperty("apiBaseUrl", System.getProperty("apiBaseUrl", "https://jsonplaceholder.typicode.com"));
    }

    private ConfigManager() {
        // prevent instantiation
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }
}
