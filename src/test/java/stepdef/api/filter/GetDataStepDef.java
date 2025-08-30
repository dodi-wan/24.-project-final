package stepdef.api.filter;

import helper.api.ApiUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pages.api.create.CreatePages;
import pages.api.get.GetPages;

import java.io.IOException;

public class GetDataStepDef {

    private final CreatePages createPages;
    private Response response;
    private static String getId;

    public GetDataStepDef() throws IOException {
        RequestSpecification requestSpecification = ApiUtils.getRequestSpec();
        ApiUtils apiUtils = new ApiUtils(requestSpecification);
        createPages = new CreatePages(apiUtils);

    }


    @Given("access data api")
    public void accessDataApi() throws IOException {
        response = createPages.getListUser();
        System.out.println(response.prettyPrint());

    }


    @And("status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        System.out.println("status code = " + response.getStatusCode());
    }


    @Then("get id data")
    public void getIdData() throws IOException {
        getId = response.jsonPath().getString("data[0].id");
//        createPages.getUserById(getId);
        System.out.println( "id = " + getId);
    }



}


