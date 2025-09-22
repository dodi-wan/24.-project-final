package stepdef.api.filter;

import helper.api.ApiUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pages.api.filter.FilterDataPages;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterData {

    private final FilterDataPages filterDataPages;
    private Response response;


    public FilterData() throws IOException {
        RequestSpecification requestSpecification = ApiUtils.getRequestSpec();
        ApiUtils apiUtils = new ApiUtils(requestSpecification);
        filterDataPages = new FilterDataPages(apiUtils);
    }



    @When("user want see data have been created in current environment")
    public void userWantSeeDataHaveBeenCreatedInCurrentEnvironment() throws IOException {
        response = filterDataPages.getUserCreated();
        System.out.println(response.getBody() + response.prettyPrint());
    }

    @Then("status response is {int}")
    public void statusResponseIs(int statusCode) {
        assertEquals(statusCode, response.statusCode());
        System.out.println("Response = " + response.statusCode());

    }
}
