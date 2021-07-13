package steps;

import entities.pet.Pet;
import framework.ShopRequest;
import framework.ShopResponse;
import io.cucumber.java.en.Given;
import io.restassured.http.Method;

public class CommonSteps extends BaseSteps {

    @Given("Is configured PetShop application on address {string}")
    public void isConfiguredPetShopApplicationOnAddress(String baseAddress) {
        shopRequest.setAddress(baseAddress);
    }

    @Given("on server {string} exist entity on endpoint {string} with id {int}")
    public void onServerExistPetWithId(String word, String endpoint, int petId) {
        ShopResponse response = new ShopRequest().setRequestType(Method.GET)
                .setEndpoint(endpoint)
                .addEntityId(petId)
                .send();
        if (word.trim().toLowerCase().equals("not")) {
            if (response.getResponseCode() == 200) {
                new ShopRequest().setRequestType(Method.DELETE)
                        .setEndpoint(endpoint)
                        .addEntityId(petId)
                        .send();
            }
        } else if (word.trim().toLowerCase().equals("")) {
            if (response.getResponseCode() == 404) {
                Pet pet = new Pet();
                pet.setId(1);
                new ShopRequest().setRequestType(Method.POST)
                        .setBody(pet.toString())
                        .setEndpoint(endpoint)
                        .addEntityId(petId)
                        .send();
            }
        }
    }

}
