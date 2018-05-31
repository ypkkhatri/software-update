package com.yog.dev.sw.update.utils;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yougeshwar
 */
public class PropertyUtils {

    private static Properties properties;

    private static Properties getProperties() {
        if (properties == null) {
            try {
                properties = new Properties();
                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                properties.load(classLoader.getResourceAsStream("application.properties"));
            } catch (IOException ex) {
                Logger.getLogger(PropertyUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return properties;
    }

    public static String getValue(String key) {
        return getProperties().getProperty(key, "");
    }
}
