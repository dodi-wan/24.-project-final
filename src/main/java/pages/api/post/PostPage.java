package pages.api.post;

import helper.api.ApiUtils;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class PostPage {
    private  ApiUtils apiUtils;

    public PostPage(ApiUtils apiUtils) {
        this.apiUtils = apiUtils;
    }

    public Response postData(Map<String, Object> payload) throws IOException {
        return ApiUtils.getRequestSpec()
                .body(payload)
                .when()
                .post("user/create");
    }
}
