package stepdef.api.crud;

import helper.api.ApiUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import pages.api.put.PutPages;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateStepDef {

    private Response response;
    private final PutPages putPages;

    private RequestSpecification requestSpecification;
    private ApiUtils apiUtils;


    public UpdateStepDef() throws IOException {
        requestSpecification = apiUtils.getRequestSpec();
        apiUtils = new ApiUtils(requestSpecification);
        putPages = new PutPages(apiUtils);
    }


    @When("user update data {string} {string} {string}")
    public void userUpdateData(String id, String firstName, String lastName) throws IOException {
        Map<String, Object> updateData = new HashMap<>();
        updateData.put("id", id);
        updateData.put("firstName", firstName);
        updateData.put("lastName", lastName);

        JSONObject jsonObject = new JSONObject();
        updateData.put("id", id);
        updateData.put("firstName", firstName);
        updateData.put("lastName", lastName);

        response = putPages.putData(updateData, id);
        System.out.println("update data " + response.prettyPrint());
    }


    @Then("response should be {int}")
    public void responseShouldBe(int statuscode) {
        assertEquals(statuscode, response.getStatusCode());
        System.out.println("status code " + response.statusCode());

    }


}
