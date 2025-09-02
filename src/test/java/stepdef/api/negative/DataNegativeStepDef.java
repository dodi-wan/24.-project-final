package stepdef.api.negative;

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

public class DataNegativeStepDef {

    private Response response;
    private CreatePages createPages;
    private String createId;

    public DataNegativeStepDef() throws IOException {
        RequestSpecification requestSpecification = ApiUtils.getRequestSpec();
        ApiUtils apiUtils = new ApiUtils(requestSpecification);
        createPages = new CreatePages(apiUtils);
    }


    @Given("input {string} {string} {string} {string} {string}")
    public void input(String title, String firstname, String lastname, String email, String gender) throws IOException {
        Map<String, Object> createData = new HashMap<>();
        createData.put("title", title);
        createData.put("firstName", firstname);
        createData.put("lastName", lastname);
        createData.put("email", email);
        createData.put("gender", gender);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", firstname);
        jsonObject.put("lastName", lastname);
        jsonObject.put("email", email);
        jsonObject.put("gender", gender);

        response = createPages.postData(createData);
        createId = response.jsonPath().getString("id");
        System.out.println("result " + response.prettyPrint());
        System.out.println("id " + createId);
    }

    @Then("status code {int}")
    public void statusCode(int statuscode) {
        assertEquals(statuscode, response.getStatusCode());
    }
}

