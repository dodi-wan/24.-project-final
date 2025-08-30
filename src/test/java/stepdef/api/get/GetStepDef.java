package stepdef.api.get;

import helper.api.ApiUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pages.api.get.GetPages;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class GetStepDef {

    private GetPages getPages;
    private Response response;

    public GetStepDef() throws IOException {
        RequestSpecification requestSpecification = ApiUtils.getRequestSpec();
        ApiUtils apiUtils = new ApiUtils(requestSpecification);
        getPages = new GetPages(apiUtils);
    }


    @Given("setup link dummyapi")
    public void setupLinkDummyapi() throws IOException {
        response = getPages.getListUser();
    }


    @Then("the response status code is {int}")
    public void theResponseStatusCodeIs(int statuscode) {
        System.out.println(response);
        assertEquals(statuscode, response.getStatusCode());


    }


}
