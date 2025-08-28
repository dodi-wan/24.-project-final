package pages.api.filter;

import helper.api.ApiUtils;
import io.restassured.response.Response;

import java.io.IOException;

public class FilterDataPages {


    public Response getUserCreated() throws IOException {
        return ApiUtils.getRequestSpec()
                .when()
                .get("/user?created=1");
    }
}
