package stepdef.api.create;

import helper.api.ApiUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import pages.api.create.CreatePages;
import pages.api.get.GetPages;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateStepDef {

    private final CreatePages createPages;
    private static String createId;
    private Response response;


    public CreateStepDef() throws IOException {
        RequestSpecification requestSpecification = ApiUtils.getRequestSpec();
        ApiUtils apiUtils = new ApiUtils(requestSpecification);
        createPages = new CreatePages(apiUtils);

    }


    @Given("link url dummyapi")
    public void linkUrlDummyapi() throws IOException {
//        int statusCode = 200;
        Response getList = createPages.getListUser();
        System.out.println("result" + getList.prettyPrint() + "\n" + "status code = " + getList.statusCode());
//        Assertions.assertEquals(statusCode, 200);
    }


    @When("create data the firstname Randy and the lastname Orton")
    public void createDataTheFirstnameRandyAndTheLastnameOrton() throws IOException {
        Map<String, Object> createProduct = new HashMap<>();
        createProduct.put("title", "mr");
        createProduct.put("firstName", "Randy");
        createProduct.put("lastName", "Orton");
        createProduct.put("email", "anakajaib@wwe.com");

        response = createPages.postData(createProduct);
        System.out.println(response.prettyPrint() + "\nstatus code = " + response.statusCode());
        createId = response.jsonPath().getString("id");

        response.then()
                .body("title", org.hamcrest.Matchers.equalTo("mr"))
                .body("firstName", org.hamcrest.Matchers.equalTo("Randy"))
                .body("lastName", org.hamcrest.Matchers.equalTo("Orton"))
                .body("email", org.hamcrest.Matchers.equalTo("anakajaib@wwe.com"));
    }


    @Then("status code {int}")
    public void statusCode(int statuscode) {
        assertEquals(statuscode, response.getStatusCode());
    }


    @Then("update data")
    public void updateData() throws IOException {
        Map<String, Object> createProduct = new HashMap<>();
        createProduct.put("title", "mr");
        createProduct.put("firstName", "Randy");
        createProduct.put("lastName", "Orton");
        createProduct.put("email", "orton@wwe.com");

        response = createPages.putData(createProduct, createId);
        System.out.println(response.prettyPrint() + "\nstatus code = " +response.statusCode());
    }


    @Then("response update data should {int}")
    public void responseUpdateDataShould(int statuscode) {
        assertEquals(statuscode, response.getStatusCode());
    }

    @And("delete data")
    public void deleteData() throws IOException {
        response = createPages.deleteData(createId);
        System.out.println(response.prettyPrint() + response.statusCode());
    }


    @Then("response delete data should {int}")
    public void responseDeleteDataShould(int statuscode) {
        assertEquals(statuscode, response.getStatusCode());
    }
}

//1miliar47jutabelly
//https://dummyapi.io/data/v1/user/689de5600e2f2a43d7bb709b
//689dee3a0e2f2a83c0bb756f