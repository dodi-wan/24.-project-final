package stepdef.api.edge;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import pages.api.create.CreatePages;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EdgeStepDef {

    private final CreatePages createPages;
    private Response response;

    public EdgeStepDef() {
        createPages = new CreatePages();
    }



    @Given("input {string} {string} {string} {string}")
    public void input(String title, String firstname, String lastname, String email) throws IOException {
        Map<String, Object> edgeData = new HashMap<>();
        edgeData.put("title", title);
        edgeData.put("firstName", firstname);
        edgeData.put("lastName", lastname);
        edgeData.put("email", email);

        response = createPages.postData(edgeData);
//        System.out.println(response.prettyPrint() + response.statusCode());
//
//        response.then()
//                .body("title", org.hamcrest.Matchers.equalTo(title))
//                .body("firstName", org.hamcrest.Matchers.equalTo(firstname))
//                .body("lastName", org.hamcrest.Matchers.equalTo(lastname))
//                .body("email", org.hamcrest.Matchers.equalTo(email));
    }

    @Then("code is {int}")
    public void codeIs(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }
}
