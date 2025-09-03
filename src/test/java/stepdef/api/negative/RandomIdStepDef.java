package stepdef.api.negative;

import helper.api.ApiUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pages.api.crud.CreatePages;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomIdStepDef {

    private Response response;
    private CreatePages createPages;

    public RandomIdStepDef() throws IOException {
        RequestSpecification requestSpecification = ApiUtils.getRequestSpec();
        ApiUtils apiUtils = new ApiUtils(requestSpecification);
        createPages = new CreatePages(apiUtils);
    }

    @Given("get {string}")
    public void get(String id) throws IOException {
        response = createPages.getUserById(id);
        System.out.println("result " + response);

    }

    @Then("response status code {int}")
    public void responseStatusCode(int statuscode) {
        assertEquals(statuscode, response.statusCode());
    }
}
