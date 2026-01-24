package framework.api.tests;

import framework.api.base.BaseApiTest;
import framework.api.client.ApiClient;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GetUsersApiTest extends BaseApiTest {
    private static final Logger logger = LogManager.getLogger(GetUsersApiTest.class);

    @Test
    public void shouldReturnListOfUsersForValidPage() {
        Response response = ApiClient.get("/users");
        logger.info("Status Code: {}", response.getStatusCode());
        if (response.getStatusCode() != 200) {
            logger.error("Response Body: {}", response.getBody().asString());
        }
        Assert.assertEquals(response.statusCode(), 200, "GET /users should return HTTP 200");
    }
}
