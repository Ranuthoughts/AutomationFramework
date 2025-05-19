package StepDefinition;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import pojo.TeammembersList;
import pojo.teamresponse;
import pojo.teamsrequest;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;

import com.fasterxml.jackson.databind.ObjectMapper;

import Resources.APIResources;
import Resources.TestDatabuild;
import Resources.Utilities;

public class TeamsStepDefinition extends Utilities {
	RequestSpecification teamsrequest;
	String teamsresponse;

	@Given("User successfully login on the portal")
	public void user_successfully_login_on_the_portal() {
		// Write login logic here

	}

	@When("Click on Team Member using filter")
	public void click_on_team_member_using_filter() throws JsonProcessingException, IOException {
		teamsrequest teamsreq = new teamsrequest();
		teamsrequest = given().spec(requestspecification()).log().all().header("X-Auth-Token", getGlobalValues("Token"))
				.body(TestDatabuild.teamspayload());
	}

	@Then("Data should be filtered according to the selected filter")
	public void data_should_be_filtered_according_to_the_selected_filter() {
//		APIResources resourceAPI = APIResources.valueOf(resource);
		teamsresponse = teamsrequest.when().post("/ecms_portal/team/members/getAllTeamMembersTB").then().log().all()
				.spec(responseSpecification()).extract().response().asString();

		JsonPath js = new JsonPath(teamsresponse);
		String getStatus = js.get("status");
		System.out.println(getStatus);

	}

	@Then("Find the count of active and inactvive teammembers using {string} API.")
	public void find_the_count_of_active_and_inactvive_teammembers_using_api(String resource)
			throws JsonMappingException, com.fasterxml.jackson.core.JsonProcessingException {
		
		teamsresponse = teamsrequest.when().post("/ecms_portal/team/members/getAllTeamMembersTB").then().log().all()
				.spec(responseSpecification()).extract().response().asString();
		if (teamsresponse == null || teamsresponse.isEmpty()) {
			throw new IllegalStateException("API response is null or empty. Check API call.");
		}
		ObjectMapper objectmapper = new ObjectMapper();
		teamresponse extractteams = objectmapper.readValue(teamsresponse, teamresponse.class);
		System.out.println("API status: " + extractteams.status);
		System.out.println("API message: " + extractteams.message);
		System.out.println("Raw resultObj: " + extractteams.resultObj);
		// extract mobile no from the reponse.

		List<TeammembersList> teamMembers = objectmapper.convertValue(extractteams.resultObj.get(0),
				new TypeReference<List<TeammembersList>>() {
				});
		int totalCount = (int) objectmapper.convertValue(extractteams.resultObj.get(1), Integer.class);
		String teammemberstatus = objectmapper.convertValue(extractteams.resultObj.get(1), String.class);

		System.out.println("======= RAW API RESPONSE START =======");
		System.out.println("Total team members from API: " + totalCount);
		System.out.println("Parsed team members list size: " + teamMembers.size());
		long activeCount = teamMembers.stream().filter(member -> "ACTIVE".equalsIgnoreCase(member.status)).count();
//        assertEquals(activeCount , "1");

		long inactiveCount = teamMembers.stream().filter(member -> !"ACTIVE".equalsIgnoreCase(member.status)).count();

		System.out.println("Active members count: " + activeCount);
		System.out.println("Inactive members count: " + inactiveCount);
		assertEquals(inactiveCount, 1);

		System.out.println("======= RAW API RESPONSE END =======");

	}

}
