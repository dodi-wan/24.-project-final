package stepdef.api.crud;

import helper.api.ApiUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import pages.api.crud.CreatePages;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateStepDef {

    private Response response;
    private CreatePages createPages;

    public UpdateStepDef() throws IOException {
        RequestSpecification requestSpecification = ApiUtils.getRequestSpec();
        ApiUtils apiUtils = new ApiUtils(requestSpecification);
        createPages = new CreatePages(apiUtils);
    }


    @Given("update data {string} {string} {string}")
    public void updateData(String id, String firstName, String lastName) throws IOException {
        Map<String, Object> updateData = new HashMap<>();
        updateData.put("id", id);
        updateData.put("firstName", firstName);
        updateData.put("lastName", lastName);

        JSONObject jsonObject = new JSONObject();
        updateData.put("id", id);
        updateData.put("firstName", firstName);
        updateData.put("lastName", lastName);

        response = createPages.putData(updateData, id);
        System.out.println("update data " + response.prettyPrint());

    }

    @Then("response should be {int}")
    public void responseShouldBe(int statuscode) {
        assertEquals(statuscode, response.getStatusCode());
        System.out.println("status code " + response.statusCode());

    }
}
