package stepdef.api.edge;

import helper.api.ApiUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import pages.api.post.PostPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EdgeEmailStepDef {

    private Response response;
    private final PostPage postPage;
    private RequestSpecification requestSpecification;
    private ApiUtils apiUtils;


    public EdgeEmailStepDef() throws IOException {
        requestSpecification = apiUtils.getRequestSpec();
        apiUtils = new ApiUtils(requestSpecification);
        postPage = new PostPage(apiUtils);
    }

    @When("user input data {string} {string} {string} {string}")
    public void userInputData(String title, String firstName, String lastName, String email) throws IOException {
        Map<String, Object> createData = new HashMap<>();
        createData.put("title", title);
        createData.put("firstName", firstName);
        createData.put("lastName", lastName);
        createData.put("email", email);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", title);
        jsonObject.put("firstName", firstName);
        jsonObject.put("lastName", lastName);
        jsonObject.put("email", email);

        response = postPage.postData(createData);
        System.out.println("result " + response.prettyPrint());
    }

    @Then("code should be {int}")
    public void codeShouldBe(int statuscode) {
        assertEquals(statuscode, response.statusCode());
        System.out.println("RESPONSE " + response.statusCode());
    }
}
