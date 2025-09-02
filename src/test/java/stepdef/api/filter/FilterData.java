package stepdef.api.filter;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import pages.api.filter.CreatedPages;

import java.io.IOException;

public class FilterData {

    private final CreatedPages filterDataPages;
    private Response response;


    public FilterData(){
        filterDataPages = new CreatedPages();
    }


    @Given("filter data api")
    public void filterDataApi() throws IOException {
    response = filterDataPages.getUserCreated();
    System.out.println(response.getBody() + response.prettyPrint());
    }
}
