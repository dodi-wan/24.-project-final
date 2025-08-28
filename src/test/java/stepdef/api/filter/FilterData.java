package stepdef.api.filter;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import pages.api.filter.FilterDataPages;

import java.io.IOException;

public class FilterData {

    private final FilterDataPages filterDataPages;
    private Response response;


    public FilterData(){
        filterDataPages = new FilterDataPages();
    }

    @Given("filter data api")
    public void filterDataApi() throws IOException {
    response = filterDataPages.getUserCreated();
    System.out.println(response.getBody() + response.prettyPrint());
    }
}
