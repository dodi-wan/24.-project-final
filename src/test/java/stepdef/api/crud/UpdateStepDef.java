package stepdef.api.crud;

import helper.api.ApiUtils;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import pages.api.crud.CreatePages;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UpdateStepDef {

    private Response response;
    private CreatePages createPages;

    public UpdateStepDef() throws IOException {
        RequestSpecification requestSpecification = ApiUtils.getRequestSpec();
        ApiUtils apiUtils = new ApiUtils(requestSpecification);
        createPages = new CreatePages(apiUtils);
    }


    @Given("update data {string} {string} {string} {string} {string}")
    public void updateData(String id, String title, String firstName, String lastName, String gender) throws IOException {
        Map<String, Object> updateData = new HashMap<>();
        updateData.put("id", id);
        updateData.put("title", title);
        updateData.put("firstName", firstName);
        updateData.put("lastName", lastName);
        updateData.put("gender", gender);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", title);
        jsonObject.put("firstName", firstName);
        jsonObject.put("lastName", lastName);
        jsonObject.put("gender", gender);

        response = createPages.putData(updateData, id);
        System.out.println("update data " + response.prettyPrint());
        System.out.println("status code " + response.statusCode());
    }

}
