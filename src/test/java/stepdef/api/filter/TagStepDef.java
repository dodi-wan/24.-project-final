package stepdef.api.filter;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import pages.api.create.CreatePages;

import java.io.IOException;

public class TagStepDef {

    private CreatePages createPages;
    private static String date;
    private Response response;



    public TagStepDef(){
        createPages = new CreatePages();
    }



    @Given("input date current")
    public void inputDateCurrent() throws IOException {
        date = "?date=2025-08-21";
        response  = createPages.getListUser(date);
        System.out.println(response.prettyPrint());
    }
}
