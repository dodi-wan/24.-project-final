package stepdef.api.get;

import helper.api.ApiUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pages.api.get.GetPages;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetStepDef {

    private final GetPages getPages;
    private Response response;

    private RequestSpecification requestSpecification;
    private ApiUtils apiUtils;

    public GetStepDef() throws IOException {
        requestSpecification = apiUtils.getRequestSpec();
        apiUtils = new ApiUtils(requestSpecification);
        getPages = new GetPages(apiUtils);
    }



    @When("user GET all data on API dummyapi.io")
    public void userGETAllDataOnAPIDummyapiIo() throws IOException {
        response = getPages.getListUser();
        System.out.println(response.prettyPrint());
    }



    @Then("the response status code is {int}")
    public void theResponseStatusCodeIs(int statuscode) {
        System.out.println(response);
        assertEquals(statuscode, response.getStatusCode());
    }
}
