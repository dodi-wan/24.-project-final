package stepdef.api.negative;

import helper.api.ApiUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pages.api.get.GetPages;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomIdStepDef {

    private Response response;
    private final GetPages getPages;

    private RequestSpecification requestSpecification;
    private ApiUtils apiUtils;

    public RandomIdStepDef() throws IOException {
        requestSpecification = ApiUtils.getRequestSpec();
        apiUtils = new ApiUtils(requestSpecification);
        getPages = new GetPages(apiUtils);
    }



    @When("user get {string}")
    public void userGet(String id) throws IOException {
        response = getPages.getUserById(id);
        System.out.println("result " + response);
    }



    @Then("response status code {int}")
    public void responseStatusCode(int statuscode) {
        assertEquals(statuscode, response.statusCode());
        System.out.println("status respon " + response.statusCode());
    }
}
