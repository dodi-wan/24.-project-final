package stepdef.api.filter;

import helper.api.ApiUtils;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pages.api.filter.FilterDataPages;

import java.io.IOException;

public class FilterData {

    private final FilterDataPages filterDataPages;
    private Response response;


    public FilterData() throws IOException {
        RequestSpecification requestSpecification = ApiUtils.getRequestSpec();
        ApiUtils apiUtils = new ApiUtils(requestSpecification);
        filterDataPages = new FilterDataPages(apiUtils);
    }


    @Given("filter data api")
    public void filterDataApi() throws IOException {
    response = filterDataPages.getUserCreated();
    System.out.println(response.getBody() + response.prettyPrint());
    }
}
