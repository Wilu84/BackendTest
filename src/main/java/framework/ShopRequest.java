package framework;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ShopRequest {

    private Method requestType;
    private String endpointAddress;
    private RequestSpecification requestSpecification = RestAssured.given();

    public ShopRequest setAddress(String address) {
        RestAssured.baseURI = address;
        return this;
    }

    public ShopRequest setRequestType(Method type) {
        requestType = type;
        return this;
    }

    public ShopRequest setBody(String body) {
        requestSpecification = requestSpecification.body(body);
        return this;
    }

    public ShopRequest setEndpoint(String endpoint){
        endpointAddress = endpoint;
        return this;
    }

    public ShopRequest addEntityId(int id){
        if (!endpointAddress.endsWith("/")){
            endpointAddress = endpointAddress.concat("/");
        }
        endpointAddress = endpointAddress.concat(Integer.toString(id));
        return this;
    }

    public ShopResponse send() {
        Response response;
        switch (requestType) {
            case GET:
                response = requestSpecification.get(endpointAddress);
                break;
            case DELETE:
                response = requestSpecification.delete(endpointAddress);
                break;
            case POST:
                response = requestSpecification.post(endpointAddress);
                break;
            default:
                throw new NotImplementedException();
        }
        requestSpecification = null;
        return new ShopResponse(response);
    }

}

