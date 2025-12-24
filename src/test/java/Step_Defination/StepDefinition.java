package Step_Defination;



import java.io.IOException;
//import org.testng.Assert;

import org.junit.Assert;

import Resourcs.ApiResources;
import Resourcs.TestDataBuild;
import Resourcs.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;

public class StepDefinition extends Utils{
	
	ResponseSpecification resp;
	public RequestSpecification request;
	public Response response;
    TestDataBuild data=new TestDataBuild();
    static String place_id;

@Given("Add Place Payload with {string} {string} {string}")
public void add_place_payload_with(String string, String string2, String string3) throws IOException  {
	 
	request=given().spec(requestSpecification())
			.body(data.addPlacePayload( string, string2, string3));
}

@When("User calls {string} with {string} http request")
public void user_calls_with_http_request(String string, String string2) {
	ApiResources resource=ApiResources.valueOf(string);
	System.out.println(resource.getResource());
	// use string2 to check type of http method
	if (string2.equalsIgnoreCase("POST"))
		response = request.when().post(resource.getResource());
	else if (string2.equalsIgnoreCase("GET"))
		response = request.when().get(resource.getResource());
	else if (string2.equalsIgnoreCase("DELETE"))
		response = request.when().delete(resource.getResource());
	else if (string2.equalsIgnoreCase("PUT"))
		response = request.when().put(resource.getResource());
	
			}

@Then("API call got success with status code {int}")
public void api_call_got_success_with_status_code(Integer int1) {
    response.then().spec(responseSpecification());
}

@Then("{string} in response body is {string}")
public void in_response_body_is(String string, String string2) {
   Assert.assertEquals(getJsonPath(response,string),string2);
}
@Then("verify place_id created maps to {string} using {string}")
public void verify_place_id_created_maps_to_using(String expectedname, String resourcename) throws IOException {
    // Write code here that turns the phrase above into concrete actions
	place_id=getJsonPath(response,"place_id");
	request=given().spec(requestSpecification()).queryParam("place_id",place_id);
	user_calls_with_http_request(resourcename, "GET");
	String actualname=getJsonPath(response,"name");
	Assert.assertEquals(actualname, expectedname);
    
}
@Given("DeletePlace Payload")
public void delete_place_payload() throws IOException {
    // Write code here that turns the phrase above into concrete actions
        request=given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
        
        
}
}
