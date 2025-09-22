package stepdef.api.crud;

import helper.api.ApiUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import pages.api.delete.DeletePages;
import pages.api.post.PostPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FullData {

    private final PostPage postPage;
    private final DeletePages deletePages;

    private Response response;
    private static String createId;

    private RequestSpecification requestSpecification;
    private ApiUtils apiUtils;


    public FullData() throws IOException {
        requestSpecification = apiUtils.getRequestSpec();
        apiUtils = new ApiUtils(requestSpecification);
        postPage = new PostPage(apiUtils);
        deletePages = new DeletePages(apiUtils);
    }



    @When("input {string} {string} {string} {string} {string} {string} {string}" +
            " and location {string} {string} {string} {string} {string}")
    public void inputAndLocation(String title, String firstname, String lastname, String email, String dateOfBirth,
                                 String phone, String picture, String street, String city, String state, String country,
                                 String timezone) throws IOException {
        Map<String, Object> createData = new HashMap<>();
        createData.put("title", title);
        createData.put("firstName", firstname);
        createData.put("lastName", lastname);
        createData.put("email", email);
        createData.put("dateOfBirth", dateOfBirth);
        createData.put("phone", phone);
        createData.put("picture", picture);
        createData.put("street", street);
        createData.put("city", city);
        createData.put("state", state);
        createData.put("country", country);
        createData.put("timezone", timezone);

        JSONObject user = new JSONObject();
        user.put("title", title);
        user.put("firstName", firstname);
        user.put("lastName", lastname);
        user.put("email", email);
        user.put("dataOfBirth", dateOfBirth);
        user.put("phone", phone);
        user.put("picture", picture);
        user.put("street", street);
        user.put("city", city);
        user.put("state", state);
        user.put("country", country);
        user.put("timezone", timezone);

        response = postPage.postData(createData);
        createId = response.jsonPath().getString("id");

        System.out.println("respon code " + response.statusCode());
        System.out.println("body " + response.prettyPrint());
        System.out.println("ID " + createId);
    }



    @Then("status code should {int}")
    public void statusCodeShould(int expectedCode) {
        System.out.println(response.statusCode());
        assertEquals(expectedCode, response.getStatusCode());
    }



    @And("delete user")
    public void deleteUser() throws IOException {
        String id = createId;
        response = deletePages.deleteData(id);
        System.out.println(response.prettyPrint() + response.statusCode());
    }



    @Then("the response is {int}")
    public void theResponseIs(int statuscode) {
        assertEquals(statuscode, response.getStatusCode());
    }
}
