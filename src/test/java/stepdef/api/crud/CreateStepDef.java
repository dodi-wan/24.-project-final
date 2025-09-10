package stepdef.api.crud;

import helper.api.ApiUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

public class CreateStepDef {

    private final PostPage postPage;
    private final GetPages getPages;
    private final DeletePages deletePages;

    private static String createId;
    private Response response;

    private RequestSpecification requestSpecification;
    private ApiUtils apiUtils;


    public CreateStepDef() throws IOException {
        requestSpecification = apiUtils.getRequestSpec();
        apiUtils = new ApiUtils(requestSpecification);
        postPage = new PostPage(apiUtils);
        getPages = new GetPages(apiUtils);
        deletePages = new DeletePages(apiUtils);
    }


    @Given("link url dummyapi")
    public void linkUrlDummyapi() throws IOException {
        Response getList = getPages.getListUser();
        System.out.println("result" + getList.prettyPrint() + "\n" + "status code = " + getList.statusCode());
    }


    @Given("input data {string} {string} {string} {string}")
    public void inputData(String title, String firstname, String lastname, String email) throws IOException {
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


    @Then("status code is {int}")
    public void statusCodeIs(int statuscode) {
        assertEquals(statuscode, response.getStatusCode());
    }


    @And("delete data")
    public void deleteData() throws IOException {
        response = deletePages.deleteData(createId);
        System.out.println(response.prettyPrint() + response.statusCode());
        System.out.println("result " + response.print());
    }


    @Then("response delete data should {int}")
    public void responseDeleteDataShould(int statuscode) {
        assertEquals(statuscode, response.getStatusCode());
    }
}
