package steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.pet.Pet;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Method;
import org.junit.Assert;

public class PetSteps extends BaseSteps {

    @When("users sends {string} request to {string} endpoint")
    public void usersSendsRequestToEndpoint(String method, String address) {
        shopResponse = shopRequest.setEndpoint(address)
                .setRequestType(Method.valueOf(method))
                .send();
    }

    @Then("service returns response {int}")
    public void serviceReturnsResponse(int responseCode) {
        Assert.assertEquals("Response code is different than expected",
                responseCode, shopResponse.getResponseCode());
    }

    @And("service return pet with id {int}")
    public void serviceReturnPetWithId(int petId) throws JsonProcessingException {
        Pet pet = new ObjectMapper().readValue(shopResponse.getBodyResponse(), Pet.class);

        Assert.assertEquals("Pet has different id than expected",
                petId, pet.getId());
    }
}
