package pages.api.get;

import helper.api.ApiUtils;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class GetPages {

    private Response response;
    private ApiUtils apiUtils;

    public GetPages(ApiUtils apiUtils) {
        this.apiUtils = apiUtils;
    }


    public Response getListUser() throws IOException {
        return apiUtils.getRequestSpec()
                .when()
                .get("/user/");
    }


}
