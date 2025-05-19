package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;
import pojo.Virtualaccres;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import Resources.APIResources;
import Resources.Utilities;

//import org.junit.runner.Request;

public class StepDefination extends Utilities {

	Virtualaccres response;
	RequestSpecification virtualrequest;

	@Given("Email id and Password")
	public void email_id_and_password() throws IOException {

		virtualrequest = given().spec(requestspecification()).log().all()
				.header("X-Auth-Token", getGlobalValues("Token")).body("");

//		response = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	}

	@When("User will login using email id and password with {string} API using {string} method.")
	public void user_will_using_email_id_and_password_with_api_using_method(String resource, String method) {
		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getresource());
		response = virtualrequest.when().post(resourceAPI.getresource()).then().log().all().assertThat()
				.spec(responseSpecification()).extract().response().as(Virtualaccres.class);

	}

	@Then("API will automatically call for Virtual Account details with {string} code {string}.")
	public void api_will_automatically_call_for_virtual_account_details_with_code(String string1, String string2) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println(response.getMessage());
		System.out.println(response.getStatus());
		System.out.println(response.getResultObj().getAccountHolderName());
		System.out.println(response.getResultObj().getBalance());

	}

	@Then("{string} will fetch in Account details.")
	public void will_fetch_in_account_details(String string) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatus(), "SUC2001");

	}

	@Then("{string} will fetch in response.")
	public void will_fetch_in_response(String string) {
		// Write code here that turns the phrase above into concrete actions

	}

}
