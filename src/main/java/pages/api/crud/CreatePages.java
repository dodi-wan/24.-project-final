package pages.api.crud;

import helper.api.ApiUtils;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class CreatePages {
    private ApiUtils apiUtils;



    public CreatePages(ApiUtils apiUtils) {
        this.apiUtils = apiUtils;
    }



    public Response getListUser() throws IOException {
        return apiUtils.getRequestSpec()
                .when()
                .get("user/");
    }



    public Response postData(Map<String, Object> payload) throws IOException {
        return ApiUtils.getRequestSpec()
                .body(payload)
                .when()
                .post("user/create");
    }



    public Response putData(Map<String, Object> payload, String id) throws IOException {
        return ApiUtils.getRequestSpec()
                .body(payload)
                .when()
                .put("/user/"  + id);
    }



    public Response deleteData(String id) throws IOException {
        return ApiUtils.getRequestSpec()
                .when().delete("/user/" + id);
    }



    public Response getUserById(String userId) throws IOException {
        return ApiUtils.getRequestSpec()
                .when()
                .get("user?" + userId);
    }



    public Response getBulkById(List<String> id) throws IOException {
        return ApiUtils.getRequestSpec()
                .when()
                .get("user/" + "?" + id);
    }
}









