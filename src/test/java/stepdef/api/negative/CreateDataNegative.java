package stepdef.api.negative;

import helper.api.ApiUtils;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import pages.api.delete.DeletePages;
import pages.api.get.GetPages;
import pages.api.post.PostPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateDataNegative {


    private Response response;
    private final PostPage postPage;
    private final DeletePages deletePages;
    private final GetPages getPages;
    private static String createId;

    private RequestSpecification requestSpecification;
    private ApiUtils apiUtils;


    public CreateDataNegative() throws IOException {
        requestSpecification = apiUtils.getRequestSpec();
        apiUtils = new ApiUtils(requestSpecification);
        postPage = new PostPage(apiUtils);
        deletePages = new DeletePages(apiUtils);
        getPages = new GetPages(apiUtils);
    }



    @When("user create data {string} {string} {string} {string}")
    public void userCreateData(String title, String firstname, String lastname, String email) throws IOException {
        Map<String, Object> createData = new HashMap<>();
        createData.put("title", title);
        createData.put("firstName", firstname);
        createData.put("lastName", lastname);
        createData.put("email", email);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", title);
        jsonObject.put("firstName", firstname);
        jsonObject.put("lastName", lastname);
        jsonObject.put("email", email);

        response = postPage.postData(createData);
        createId = response.jsonPath().getString("id");
        System.out.println("result : \n" + response.prettyPrint());
        System.out.println("ID " + createId);
    }



    @Then("response status code is {int}")
    public void responseStatusCodeIs(int statuscode) {
        assertEquals(statuscode, response.statusCode(), "status error");
    }



    @When("user delete data id")
    public void userDeleteDataId() throws IOException {
        response = deletePages.deleteData(createId);
        System.out.println("result " + response.print());
    }



    @But("user try get id already delete it")
    public void userTryGetIdAlreadyDeleteIt() throws IOException {
        response = getPages.getUserById(createId);
        System.out.println("result " + response );
    }



    @Then("response code is {int}")
    public void responseCodeIs(int statuscode) {
        assertEquals(statuscode, response.statusCode());
        System.out.println("status code " + response.statusCode());
    }
}
