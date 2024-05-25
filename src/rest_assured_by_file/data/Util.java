package rest_assured_by_file.data;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import java.io.*;

public class Util {

    public static RequestSpecification getReqresInRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/api")
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification getReqresResponseSpec() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    public static File serializeObject(Book book, String fileName) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(book);
            objectOutputStream.flush();
            return new File(fileName);
        } catch (IOException e) {
            throw new RuntimeException("Not able to serialize object: ", e);
        }
    }

    public static Book deserializeObject(String fileName) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))){
            return (Book) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Not able to deserialize object: ", e);
        }
    }

    public static ResponseSpecification getPostmanEchoJsonResponse() {
        return new ResponseSpecBuilder().build();
    }

    public static RequestSpecification getPostmanEchoJsonRequestSpec() {
        return new RequestSpecBuilder().addHeader("accept", "*/*").setContentType("application/json")
                .setBaseUri("https://postman-echo.com").build();
    }
}
