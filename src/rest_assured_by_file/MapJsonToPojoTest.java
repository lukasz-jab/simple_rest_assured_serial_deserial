package rest_assured_by_file;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.Test;
import rest_assured_by_file.data.ReqResResponsePojo;

import static io.restassured.RestAssured.given;
import static rest_assured_by_file.data.Util.*;

public class MapJsonToPojoTest {

    @Test
    public void shouldBeAbleToMapJsonToPojo(){
        ReqResResponsePojo pojo = given(getReqresInRequestSpec())
                .when()
                .get("/users/2")
                .then()
                .spec(getReqresResponseSpec())
                .extract().as(ReqResResponsePojo.class);

        assert(pojo.getData().getFirstName().equals("Janet"));
    }
}
