package pages.api.put;

import helper.api.ApiUtils;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class PutPages {
    private ApiUtils apiUtils;



    public PutPages(ApiUtils apiUtils) {
        this.apiUtils = apiUtils;
    }


    public Response putData(Map<String, Object> payload, String id) throws IOException {
        return ApiUtils.getRequestSpec()
                .body(payload)
                .when()
                .put("/user/"  + id);
    }








}









