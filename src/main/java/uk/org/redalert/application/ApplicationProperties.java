package uk.org.redalert.application;

import org.apache.commons.lang.StringUtils;
import org.hibernate.PropertyNotFoundException;

import java.io.*;
import java.util.Properties;

public enum ApplicationProperties {
    PORT,
    DATABASE_URL,
    HIBERNATE_DIALECT("hibernate.dialect"),
    HIBERNATE_SHOW_SQL("hibernate.show_sql"),
    HIBERNATE_HM2DLL_AUTO("hibernate.hbm2ddl.auto"),
    PSQL_DRIVER("psql.driver");

    private String value;
    private String name;

    ApplicationProperties() {
        setValue(this.toString());
    }

    ApplicationProperties(String name) {
        this.name = name;
        setValue(name);
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String reqValue) {
        InputStream is = getClass().getClassLoader().getResourceAsStream("application.properties");
        Properties prop = new Properties();
        try {
            prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        value = System.getenv(reqValue);
        if (StringUtils.isBlank(value)) {
            value = prop.getProperty(reqValue);
            if (value == null) {
                throw new PropertyNotFoundException("Property not found: " + reqValue);
            }
        }
    }
}

