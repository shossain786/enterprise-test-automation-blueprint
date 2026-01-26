package framework.api.tests;


import framework.api.client.ApiClient;
import framework.api.model.CreatePostRequest;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import framework.api.base.BaseApiTest;

public class CreatePostApiTest extends BaseApiTest {
    public static final Logger logger = LogManager.getLogger(CreatePostApiTest.class.getName());

    @Test
    public void createPostApiTest() {
        CreatePostRequest request = new CreatePostRequest(
                "automation blueprint",
                "post api test using testing and rest assured",
                1
        );
        Response response = ApiClient.post("/posts", request);
        logger.info("POST /posts status code: {}", response.getStatusCode());

        if (response.getStatusCode() != 200) {
            logger.info("POST /posts body: {}", response.getBody().asString());
        }
        Assert.assertEquals(response.getStatusCode(), 201,
                "POST /posts status code should be 201");

        Assert.assertNotNull(response.jsonPath().get("id"),
                "Created post should return an id");

    }
}
