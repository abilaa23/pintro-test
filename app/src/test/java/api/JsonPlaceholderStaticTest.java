package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JsonPlaceholderStaticTest {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    public void testListAllPosts() {
        Response response = given()
            .get("/posts")
            .then()
            .statusCode(200)
            .extract()
            .response();

        assertTrue(response.jsonPath().getList("$").size() > 0);
    }

    @Test
    public void testGetSinglePost() {
        Response response = given()
            .get("/posts/1")
            .then()
            .statusCode(200)
            .extract()
            .response();

        assertEquals(1, response.jsonPath().getInt("id"));
        assertEquals(1, response.jsonPath().getInt("userId"));
    }

    @Test
    public void testCreatePost() {
        String requestBody = """
            {
              "title": "Test Post",
              "body": "This is a test post content.",
              "userId": 10
            }
        """;

        Response response = given()
            .header("Content-type", "application/json")
            .body(requestBody)
            .post("/posts")
            .then()
            .statusCode(201)
            .extract()
            .response();

        assertEquals("Test Post", response.jsonPath().getString("title"));
        assertEquals("This is a test post content.", response.jsonPath().getString("body"));
        assertEquals(10, response.jsonPath().getInt("userId"));
    }

    @Test
    public void testPatchPost() {
        String requestBody = """
            {
              "title": "Updated Title"
            }
        """;

        Response response = given()
            .header("Content-type", "application/json")
            .body(requestBody)
            .patch("/posts/1")
            .then()
            .statusCode(200)
            .extract()
            .response();

        assertEquals("Updated Title", response.jsonPath().getString("title"));
    }
}
