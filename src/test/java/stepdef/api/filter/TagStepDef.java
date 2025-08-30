package stepdef.api.filter;

import helper.api.ApiUtils;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pages.api.create.CreatePages;
import pages.api.get.GetPages;

import java.io.IOException;

public class TagStepDef {

    private CreatePages createPages;
    private static String date;
    private Response response;



    public TagStepDef() throws IOException {
        RequestSpecification requestSpecification = ApiUtils.getRequestSpec();
        ApiUtils apiUtils = new ApiUtils(requestSpecification);
        createPages = new CreatePages(apiUtils);
    }



    @Given("input date current")
    public void inputDateCurrent() throws IOException {
        date = "?date=2025-08-21";
        response  = createPages.getListUser();
        System.out.println(response.prettyPrint());
    }
}
