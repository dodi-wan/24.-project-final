package stepdef.api.negative;

import helper.api.ApiUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import pages.api.post.PostPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataNegativeStepDef {

    private Response response;
    private final PostPage postPage;
    private String createId;

    private RequestSpecification requestSpecification;
    private ApiUtils apiUtils;

    public DataNegativeStepDef() throws IOException {
        requestSpecification = ApiUtils.getRequestSpec();
        apiUtils = new ApiUtils(requestSpecification);
        postPage = new PostPage(apiUtils);
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

        response = postPage.postData(createData);
        createId = response.jsonPath().getString("id");
        System.out.println("result " + response.prettyPrint());
        System.out.println("id " + createId);
    }

    @Then("status code {int}")
    public void statusCode(int statuscode) {
        assertEquals(statuscode, response.getStatusCode());
    }
}

