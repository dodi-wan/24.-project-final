package helper.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class ApiUtils {

    private static RequestSpecification requestSpecification;
    private static String URL;

    public ApiUtils(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }





    public static RequestSpecification getRequestSpec() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/options.properties"));

        URL = properties.getProperty("url");


        if (requestSpecification == null){
            requestSpecification = given()
                    .baseUri(URL)
                    .header("app-id", "63a804408eb0cb069b57e43a")
                    .contentType("application/json");
        }
        return requestSpecification;
    }




}
