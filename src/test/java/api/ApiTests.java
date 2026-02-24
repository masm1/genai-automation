package api;

import org.testng.annotations.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ApiTests {

    @Test
    public void getUsersTest() {
        ApiBase.setup();
        Response response = given()
                .when()
                .get("/users?page=2");

        response.then().statusCode(200);
    }

    @Test
    public void createUserTest() {
        ApiBase.setup();

        String body = "{ \"name\": \"Sumit\", \"job\": \"QA\" }";

        given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/users")
                .then()
                .statusCode(201);
    }

    @Test
    public void unauthorizedTest() {
        ApiBase.setup();

        given()
                .when()
                .get("/unknown/23")
                .then()
                .statusCode(404);
    }
}