import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostmanTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGet() {
        Response response = given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get");

        Assert.assertEquals(response.getStatusCode(), 200);

        String foo1Value = response.path("args.foo1");
        String foo2Value = response.path("args.foo2");

        Assert.assertEquals(foo1Value, "bar1");
        Assert.assertEquals(foo2Value, "bar2");
    }

    @Test
    public void testPost() {
        String myBody = "Hello world";

        Response response = given()
                .contentType("text/plain")
                .body(myBody)
                .when()
                .post("/post");

        Assert.assertEquals(response.getStatusCode(), 200);

        String dataValue = response.path("data");
        Assert.assertEquals(dataValue, myBody);
    }

    @Test
    public void testPut() {
        String myBody = "Updated string";

        Response response = given()
                .contentType("text/plain")
                .body(myBody)
                .when()
                .put("/put");

        Assert.assertEquals(response.getStatusCode(), 200);

        String dataValue = response.path("data");
        Assert.assertEquals(dataValue, myBody);
    }

    @Test
    public void testDelete() {
        String myBody = "Delete this";

        Response response = given()
                .contentType("text/plain")
                .body(myBody)
                .when()
                .delete("/delete");

        Assert.assertEquals(response.getStatusCode(), 200);

        String dataValue = response.path("data");
        Assert.assertEquals(dataValue, myBody);
    }
}
