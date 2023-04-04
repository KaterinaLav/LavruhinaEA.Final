package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class RequestPosts extends AbstractTest {


    @Test
    void getNotMyPost() {

        //просмотр в возрастающем порядке чужих постов авторизованного с валидным логином пользователя
        given()
                .header("X-Auth-Token", getTokenValid())
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", "100")
                .when()
                .get(getBaseUrl() + "api/posts/")
                .then()
                .statusCode(200);
    }
    /*
    @Test
    void getNotMyPostALL() {
        //Просмотр всех чужих постов авторизованного с валидным логином пользователя
        given()
                .header("X-Auth-Token", getLoginValid())
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "All")
                .when()
                .get(getBaseUrl() + "api/posts/")
                .then()
                .statusCode(401);
    }

    @Test
    void getNotMyPostNoAvtorization() {
        //просмотр постов неавторизованного пользователя
        given()
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "All")
                .queryParam("page", "1")
                .when()
                .get(getBaseUrl() + "api/posts/")
                .then()
                .statusCode(401);
    }

    @Test
    void getNotMyPostMore20() {
        //Просмотр чужих постов пользователя с логином длинее 20
        given()
                .formParam("X-Auth-Token", getLoginMore20())
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", "1")
                .when()
                .get(getBaseUrl() + "api/posts/")
                .then()
                .statusCode(401);
    }

        @Test
        void getNotMyPostDesc(){
        //Просмотр несуществующей страницы чужих постов авторизованного валидного пользователя
            given()
                .header("X-Auth-Token", getTokenValid())
                .queryParam("owner", "notMe")
                .queryParam("sort", "createdAt")
                .queryParam("order", "DESC")
                .queryParam("page", "500000000000000000000000000000000000000000")
                .when()
                .get(getBaseUrl()+"api/posts/")
                .then()
                .statusCode(500);
    }
*/
    @Test
    void getMyPost(){
        //Просмотр своих постов постов авторизованного с валидным логином пользователя
        given()
                .header("X-Auth-Token", getTokenValid())
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", "2")
                .when()
                .get(getBaseUrl() + "api/posts/")
                .then()
                .statusCode(200);
    }

    @Test
    void getMyPostNoAvtorization() {
        //просмотр своих постов неавторизованного пользователя
        given()
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", "1")
                .when()
                .get(getBaseUrl() + "api/posts/")
                .then()
                .statusCode(401);
    }
    @Test
    void getMyPostMore20() {
        //Просмотр чужих постов пользователя с логином на русском языке
        given()
                .header("X-Auth-Token", getLoginRus())
                .queryParam("sort", "createdAt")
                .queryParam("order", "ASC")
                .queryParam("page", "1")
                .when()
                .get(getBaseUrl() + "api/posts/")
                .then()
                .statusCode(401);
    }
    @Test
    void getMyPostNoPage(){
        //Просмотр несуществующей страницы своих постов авторизованного валидного пользователя
        given()
                .header("X-Auth-Token", getTokenValid())
                .queryParam("sort", "createdAt")
                .queryParam("order", "DESC")
                .queryParam("page", "500000000000000000000000000000000000000000")
                .when()
                .get(getBaseUrl()+"api/posts/")
                .then()
                .statusCode(500);
    }
    @Test
    void getMyPostDesc(){
        //Просмотр страницы в убывающем порядке своих постов авторизованного валидного пользователя
        given()
                .header("X-Auth-Token", getTokenValid())
                .queryParam("sort", "createdAt")
                .queryParam("order", "DESC")
                .queryParam("page", "5")
                .when()
                .get(getBaseUrl()+"api/posts/")
                .then()
                .statusCode(200);
    }


}
