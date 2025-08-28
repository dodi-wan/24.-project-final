package stepdef.api.edge;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pages.api.create.CreatePages;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class nameEdge {

    private final CreatePages createPages;
    private Response response;

    public nameEdge(){
        createPages = new CreatePages();
    }



    @Given("input {string} {string} {string} {string} {string}")
    public void input(String title, String firstname, String lastname, String email, String birth) throws IOException {
        Map<String, Object> createData = new HashMap<>();
        createData.put("mr", title);
        createData.put("firstName", firstname);
        createData.put("lastName", lastname);
        createData.put("email", email);
        createData.put("dateOfBirth", birth);

        response = createPages.postData(createData);
        System.out.println(response.prettyPrint() + response.statusCode());
    }

    @Then("status response is {int}")
    public void statusResponseIs(int expected) {
        assertEquals(expected, response.getStatusCode());
    }
}
