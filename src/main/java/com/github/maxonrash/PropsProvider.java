package com.github.maxonrash;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropsProvider {
    private static Properties appProps;

    static {
        String appPropsPath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "app.properties";
        Properties appProps = new Properties();

        try {
            appProps.load(new FileInputStream(appPropsPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        PropsProvider.appProps = appProps;
    }

    public static Properties getAppProps() {
        return appProps;
    }
}
