package pages.api.get;

import helper.api.ApiUtils;
import io.restassured.response.Response;

import java.io.IOException;


public class GetPages {

    private ApiUtils apiUtils;

    public GetPages(ApiUtils apiUtils) {
        this.apiUtils = apiUtils;
    }


    public Response getListUser() throws IOException {
        return apiUtils.getRequestSpec()
                .when()
                .get("/user/");
    }


    public Response getUserById(String userId) throws IOException {
        return ApiUtils.getRequestSpec()
                .when()
                .get("user/" + userId);
    }



}
