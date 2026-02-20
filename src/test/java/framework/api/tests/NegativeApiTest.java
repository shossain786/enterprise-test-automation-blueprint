package framework.api.tests;

import framework.api.base.BaseApiTest;
import framework.api.client.ApiClient;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeApiTest extends BaseApiTest {
    private static final Logger logger = LogManager.getLogger(NegativeApiTest.class);

    @Test(groups = {"api"})
    public void shouldReturn404OnInvalidEndPoint() {
        logger.info("Starting test: shouldReturn404OnInvalidEndPoint");

        try {
            Response response = ApiClient.get("/invalid-endpoint");
            logger.info("GET /invalid-endpoint status code: {}", response.getStatusCode());
            logger.debug("Response body: {}", response.getBody().asString());

            Assert.assertEquals(response.getStatusCode(), 404, "Invalid endpoint should return 404");
            logger.info("Test passed: Received expected 404 status code");
        } catch (Exception e) {
            logger.error("Test failed with exception: {}", e.getMessage(), e);
            throw e;
        }
    }
}
