package stepdef.api.edge;

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

public class EdgeStepDef {

    private final CreatePages createPages;
    private Response response;

    private RequestSpecification requestSpecification;
    private ApiUtils apiUtils;


    public EdgeStepDef() throws IOException {
        requestSpecification = apiUtils.getRequestSpec();
        ApiUtils apiUtils = new ApiUtils(requestSpecification);
        createPages = new CreatePages(apiUtils);
    }


    @Given("input data {string} {string} {string} {string} {string}")
    public void inputData(String title, String firstname, String lastname, String email, String dateOfBirth) throws IOException {
        Map<String, Object> edgeData = new HashMap<>();
        edgeData.put("title", title);
        edgeData.put("firstName", firstname);
        edgeData.put("lastName", lastname);
        edgeData.put("email", email);
        edgeData.put("dateOfBirth", dateOfBirth);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mr", title);
        jsonObject.put("firstname", firstname);
        jsonObject.put("lastname", lastname);
        jsonObject.put("mr", title);
        jsonObject.put("email", email);
        jsonObject.put("dateOfBirth", dateOfBirth);


        response = createPages.postData(edgeData);
        System.out.println(response.prettyPrint());
    }



    @Then("code is {int}")
    public void codeIs(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }


}
