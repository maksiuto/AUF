package tests.api;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given ;

public class apiHomeWork {

    @Test
    public void listUsers() {
        given()
        .when()
                .get("https://reqres.in/api/users?page=2")
        .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test
    public void singleUser() {
        given()
        .when()
                .get("https://reqres.in/api/users?page=2")
        .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test
    public void singleUserNotFound() {
        given()
        .when()
                .get("https://reqres.in/api/users/23")
        .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .log().body();
    }

    @Test
    public void listResource() {
        given()
        .when()
                .get("https://reqres.in/api/unknown")
        .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test
    public void singleResource() {
        given()
        .when()
                .get("https://reqres.in/api/unknown/2")
        .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test
    public void singleResourceNotFound() {
        given()
        .when()
                .get("https://reqres.in/api/unknown/23")
        .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .log().body();
    }

    @Test
    public void create() {
        given()
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}")
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .log().body();
    }

    @Test
    public void updatePut() {
        given()
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test
    public void updatePatch() {
        given()
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .when()
                .patch("https://reqres.in/api/users/2?name=mike&job=qa")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

}
