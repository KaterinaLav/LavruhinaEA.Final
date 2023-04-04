package org.example;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class AddUser extends AbstractTest {

    @Test
    void postNewUserValid(){

        given()
                .queryParam("token", getTokenValid())
                .contentType("application/x-www-form-urlencoded")
                .formParam("username", getLoginValid())
                .formParam("password", getPasswordValid())
                .when()
                .post(getBaseUrl()+"gateway/login")
                .then()
                .statusCode(200);

    }
    @Test
    void postNewUserMore20(){

        given()
                .queryParam("token", getTokenMore20())
                .contentType("application/x-www-form-urlencoded")
                .formParam("username", getLoginMore20())
                .formParam("password", getPasswordMore20())
                .when()
                .post(getBaseUrl()+"gateway/login")
                .then()
                .statusCode(401);
    }

    @Test
    void postNewUserRus(){

        given()
                .queryParam("token", getTokenRus())
                .contentType("application/x-www-form-urlencoded")
                .formParam("username", getLoginRus())
                .formParam("password", getPasswordRus())
                .when()
                .post(getBaseUrl()+"gateway/login")
                .then()
                .statusCode(401);
    }

}
