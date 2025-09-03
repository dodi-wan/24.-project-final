package stepdef.api.filter;

import helper.api.ApiUtils;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pages.api.crud.CreatePages;

import java.io.IOException;

public class TagStepDef {

    private final CreatePages createPages;
    private static String date;
    private Response response;

    private RequestSpecification requestSpecification;
    private ApiUtils apiUtils;


    public TagStepDef() throws IOException {
        requestSpecification = apiUtils.getRequestSpec();
        apiUtils = new ApiUtils(requestSpecification);
        createPages = new CreatePages(apiUtils);
    }



    @Given("input date current")
    public void inputDateCurrent() throws IOException {
        date = "?date=2025-09-01";
        response  = createPages.getListUser();
        System.out.println(response.prettyPrint());
    }
}
