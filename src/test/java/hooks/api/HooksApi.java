package hooks.api;

import helper.api.ApiUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class HooksApi {




    @Before("@api")
    public void setUp() throws IOException {
        ApiUtils.getRequestSpec();

    }

    @After("@api")
    public void tearDown(){

    }
}
