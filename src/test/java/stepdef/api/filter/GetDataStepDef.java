package stepdef.api.filter;

import helper.api.ApiUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pages.api.crud.CreatePages;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetDataStepDef {

    private final CreatePages createPages;
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
        createPages = new CreatePages(apiUtils);
    }


    @And("get data id {string}")
    public void getDataId(String id) throws IOException {
        response = createPages.getUserById(id);
        ID = response.jsonPath().getString("data[0].id");
        title = response.jsonPath().getString("data[0].title");
        firstname = response.jsonPath().getString("data[0].firstName");
        lastname = response.jsonPath().getString("data[0].lastName");

        System.out.println("id = " + ID);
        System.out.println("title =" + title);
        System.out.println("firstname =" + firstname);
        System.out.println("lastname =" + lastname);
    }

    @Then("response is {int}")
    public void responseIs(int statuscode) {
        assertEquals(statuscode, response.getStatusCode());
        System.out.println("response " + response.getStatusCode());
    }


    @When("get bulk {string}")
    public void getBulk(String id) throws IOException {
        List<String> addList = Arrays.asList(id.split(","));
        response = createPages.getBulkById(addList);
        List<String> ids = response.jsonPath().getList("data.id");
        System.out.println("result:\n" + ids);
    }


    @Then("status ok response is {int}")
    public void statusOkResponseIs(int statuscode) {
        assertEquals(statuscode, response.getStatusCode());
        System.out.println("result " + response.getStatusCode());
    }
}


