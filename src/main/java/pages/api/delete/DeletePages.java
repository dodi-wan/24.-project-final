package pages.api.delete;

import helper.api.ApiUtils;
import io.restassured.response.Response;

import java.io.IOException;

public class DeletePages {

    private ApiUtils apiUtils;

    public DeletePages(ApiUtils apiUtils){
        this.apiUtils = apiUtils;
    }


    public Response deleteData(String id) throws IOException {
        return ApiUtils.getRequestSpec()
                .when().delete("/user/" + id);
    }
}
