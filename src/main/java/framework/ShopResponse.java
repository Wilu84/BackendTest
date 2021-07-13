package framework;

import io.restassured.response.Response;

public class ShopResponse {

    Response response;

    ShopResponse(Response response) {
        this.response = response;
    }

    public int getResponseCode() {
        return response.statusCode();
    }

    public String getBodyResponse(){
        return response.body().print();
    }

}
