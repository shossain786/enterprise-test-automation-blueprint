package framework.config;

import java.util.Properties;

public final class ConfigManager {

    private static final Properties properties = new Properties();

    static {
        properties.setProperty("browser", System.getProperty("browser", "chrome"));
        properties.setProperty("baseUrl", System.getProperty("baseUrl", "https://example.com"));
        properties.setProperty("headless", System.getProperty("headless", "false"));
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
