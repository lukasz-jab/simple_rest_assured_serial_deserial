package rest_assured_by_file;

import org.junit.jupiter.api.Test;
import rest_assured_by_file.data.SimplePojo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static rest_assured_by_file.data.Util.getPostmanEchoJsonRequestSpec;

public class PojoAsJsonTest {

    @Test
    public void shouldBeAbleToSendPojoAsJson() {
        SimplePojo simplePojo = new SimplePojo("value1", "value2");

        given(getPostmanEchoJsonRequestSpec())
                .body(simplePojo)
                .when()
                .post("/post")
                .then()
                .assertThat()
                .body("json.key1", equalTo(simplePojo.getKey1()), "json.key2", equalTo(simplePojo.getKey2()));
    }
}
