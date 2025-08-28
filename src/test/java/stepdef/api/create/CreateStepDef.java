package stepdef.api.create;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import pages.api.create.CreatePages;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CreateStepDef {

    private final CreatePages createPages;
    private static String createId;


    public CreateStepDef() {
        createPages = new CreatePages();
    }


    @Given("link url dummyapi")
    public void linkUrlDummyapi() throws IOException {
        int statusCode = 200;
        Response getList = createPages.getListUser();
        System.out.println("result" + getList.prettyPrint() + "\n" + "status code = " + getList.statusCode());
        Assertions.assertEquals(statusCode, 200);
    }


    @When("create data the firstname Randy and the lastname Orton")
    public void createDataTheFirstnameRandyAndTheLastnameOrton() throws IOException {
        Map<String, Object> createProduct = new HashMap<>();
        createProduct.put("title", "mr");
        createProduct.put("firstName", "Randy");
        createProduct.put("lastName", "Orton");
        createProduct.put("email", "orton@wwe.com");

        Response response = createPages.postData(createProduct);
        System.out.println(response.prettyPrint() + "\nstatus code = " +response.statusCode());
        createId = response.jsonPath().getString("id");



        response.then()
//                .statusCode(200)
                .body("title", org.hamcrest.Matchers.equalTo("mr"))
                .body("firstName", org.hamcrest.Matchers.equalTo("Randy"))
                .body("lastName", org.hamcrest.Matchers.equalTo("Orton"))
                .body("email", org.hamcrest.Matchers.equalTo("orton@wwe.com"));



    }

    @Then("update data")
    public void updateData() throws IOException {
        Map<String, Object> createProduct = new HashMap<>();
        createProduct.put("title", "mr");
        createProduct.put("firstName", "Randy");
        createProduct.put("lastName", "Orton");
        createProduct.put("email", "orton@wwe.com");

        Response response = createPages.putData(createProduct, createId);
        System.out.println(response.prettyPrint() + "\nstatus code = " +response.statusCode());
    }

    @And("delete data")
    public void deleteData() throws IOException {
        Response response = createPages.deleteData(createId);
        System.out.println(response.prettyPrint() + response.statusCode());
    }
}

//1miliar47jutabelly
//https://dummyapi.io/data/v1/user/689de5600e2f2a43d7bb709b
//689dee3a0e2f2a83c0bb756f