package rest_assured_by_file;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static rest_assured_by_file.data.Util.getPostmanEchoJsonRequestSpec;
import static rest_assured_by_file.data.Util.getPostmanEchoJsonResponse;

public class ByFileTest {

    @ Test
    public void shouldBeAbleToSendJsonAsFile() {
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        System.out.println(currentPath);
        Path filePath = Paths.get(currentPath.toString(), "src", "rest_assured_by_file", "resources", "jsons", "SimpleJson.json");
        System.out.println(filePath);
        File file = new File(filePath.toString());

        ValidatableResponse test1 = given(getPostmanEchoJsonRequestSpec())
                .body(file)
                .when()
                .post("/post")
                .then()
                .spec(getPostmanEchoJsonResponse())
                .assertThat()
                .body("data.key1", equalTo("value1"), "json.key2", equalTo("value2"));

        System.out.println(test1.extract().body().asPrettyString());
    }
}
