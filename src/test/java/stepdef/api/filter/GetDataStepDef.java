package stepdef.api.filter;

import helper.api.ApiUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pages.api.get.GetPages;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetDataStepDef {

    private final GetPages getPages;
    private Response response;

    private RequestSpecification requestSpecification;
    private ApiUtils apiUtils;

    private static String ID;
    private static String firstname;
    private static String lastname;
    private static String title;

    public GetDataStepDef() throws IOException {
        requestSpecification = apiUtils.getRequestSpec();
        apiUtils = new ApiUtils(requestSpecification);
        getPages = new GetPages(apiUtils);
    }



    @When("user get data id {string}")
    public void userGetDataId(String id) throws IOException {
        response = getPages.getUserById(id);
        ID = response.jsonPath().getString("id");
        title = response.jsonPath().getString("title");
        firstname = response.jsonPath().getString("firstName");
        lastname = response.jsonPath().getString("lastName");

        System.out.println("id = " + ID);
        System.out.println("title = " + title);
        System.out.println("firstname = " + firstname);
        System.out.println("lastname = " + lastname);
    }



    @Then("response is {int}")
    public void responseIs(int statuscode) {
        assertEquals(statuscode, response.getStatusCode());
        System.out.println("response " + response.getStatusCode());
    }



    @When("user get bulk {string}")
    public void userGetBulk(String ids) throws IOException {
        List<String> idList = Arrays.asList(ids.split(","));
        for (String id : idList) {
            response = getPages.getUserById(id);
            String returnedId = response.jsonPath().getString("id");
            System.out.println("result ID: " + returnedId);
        }
    }



    @Then("status ok response is {int}")
    public void statusOkResponseIs(int statuscode) {
        assertEquals(statuscode, response.getStatusCode());
        System.out.println("result " + response.getStatusCode());
    }
}


