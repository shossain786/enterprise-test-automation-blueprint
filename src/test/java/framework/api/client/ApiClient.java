package framework.api.client;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public final class ApiClient {

    private ApiClient() {}

    public static io.restassured.response.Response get(String endpoint) {
        return given()
                .contentType(ContentType.JSON)
                .header("User-Agent", "Mozilla/5.0")
                .when()
                .get(endpoint);
    }

    public static io.restassured.response.Response post(String endpoint, Object body) {
        return given()
                .contentType(ContentType.JSON)
                .header("User-Agent", "Mozilla/5.0")
                .body(body)
                .when()
                .post(endpoint);
    }
}
