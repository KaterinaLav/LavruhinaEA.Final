package org.example;

import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class AbstractTest {

    static Properties prop = new Properties();
    private static InputStream configFile;
    private static String tokenValid;
    private static String loginValid;
    private static String passwordValid;
    private static String tokenRus;
    private static String loginRus;
    private static String passwordRus;

    private static String tokenMore20;
    private static String loginMore20;
    private static String passwordMore20;



    private static String baseUrl;

    @BeforeAll
    static void initTest() throws IOException {
        configFile = new FileInputStream("src/main/resources/my.properties");
        prop.load(configFile);

        baseUrl= prop.getProperty("base_url");

        tokenValid = prop.getProperty("tokenValid");
        loginValid = prop.getProperty("loginValid");
        passwordValid = prop.getProperty("passwordValid");

        tokenRus = prop.getProperty("tokenRus");
        loginRus = prop.getProperty("loginRus");
        passwordRus = prop.getProperty("passwordRus");

        tokenMore20 = prop.getProperty("tokenMore20");
        loginMore20 = prop.getProperty("loginMore20");
        passwordMore20 = prop.getProperty("passwordMore20");

    }

    public static String getTokenValid() {
        return tokenValid;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }
    public static String getPasswordValid() {
        return passwordValid;
    }

    public static String getLoginValid() {
        return loginValid;
    }
    public static String getTokenRus() {
        return tokenRus;
    }

    public static String getLoginRus() {
        return loginRus;
    }

    public static String getPasswordRus() {
        return passwordRus;
    }

    public static String getTokenMore20() {
        return tokenMore20;
    }

    public static String getLoginMore20() {
        return loginMore20;
    }

    public static String getPasswordMore20() {
        return passwordMore20;
    }

}
