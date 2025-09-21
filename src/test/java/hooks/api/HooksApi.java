package hooks.api;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

import static helper.api.ApiUtils.getRequestSpec;
import static helper.api.ApiUtils.getAfter;

public class HooksApi {


    @Before("@api")
    public void setUp() throws IOException {
        System.out.println("==== Before ===");

        getRequestSpec();
    }


    @After("@api")
    public void tearDown(){
        System.out.println("==== After ===");

        getAfter();
    }
}
