package framework.api.client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.given;

public final class ApiClient {
    public static final Logger logger = LogManager.getLogger(ApiClient.class);
    private ApiClient() {}

    public static Response get(String endpoint) {
        logger.debug("Making GET request to endpoint: {}", endpoint);
        Response response = given()
                .contentType(ContentType.JSON)
                .header("User-Agent", "Mozilla/5.0")
                .when()
                .get(endpoint);

        logger.info("GET {} returned status code: {}", endpoint, response.getStatusCode());
        return response;
    }

    public static io.restassured.response.Response post(String endpoint, Object body) {
        try {
            logger.debug("Making POST request to endpoint: {}", endpoint);
            logger.info("Request Body: {}", new ObjectMapper().writeValueAsString(body));
        } catch (JacksonException e) {
            logger.warn("Failed to serialize request body for logging", e);
        }
        io.restassured.response.Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("User-Agent", "Mozilla/5.0")
                .body(body)
                .when()
                .post(endpoint);

        logger.info("POST {} returned status code: {}", endpoint, response.getStatusCode());
        return response;
    }
}
