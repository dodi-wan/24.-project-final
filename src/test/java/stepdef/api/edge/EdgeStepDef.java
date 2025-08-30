package stepdef.api.edge;

import helper.api.ApiUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pages.api.create.CreatePages;
import pages.api.get.GetPages;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EdgeStepDef {

    private final CreatePages createPages;
    private Response response;

    public EdgeStepDef() throws IOException {
        RequestSpecification requestSpecification = ApiUtils.getRequestSpec();
        ApiUtils apiUtils = new ApiUtils(requestSpecification);
        createPages = new CreatePages(apiUtils);
    }



    @Given("input {string} {string} {string} {string}")
    public void input(String title, String firstname, String lastname, String email) throws IOException {
        Map<String, Object> edgeData = new HashMap<>();
        edgeData.put("title", title);
        edgeData.put("firstName", firstname);
        edgeData.put("lastName", lastname);
        edgeData.put("email", email);

        response = createPages.postData(edgeData);
    }

    @Then("code is {int}")
    public void codeIs(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }
}
