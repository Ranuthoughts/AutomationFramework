package StepDefinition;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Resources.Litebitereport;
import Resources.Utilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class AddMember extends Utilities {

	RequestSpecification addmemberrequest;
	String addmemberresponse;

	@Given("User should login on portal")
	public void user_should_login_on_portal() {

	}

	@When("Enter all the required details")
	public void enter_all_the_required_details() throws IOException {
		Map<String, Object> jsonAsMap = new HashMap<>();
		Litebitereport lb = new Litebitereport();
		ArrayList addmemberdata = lb.getdata("AddMember", "Addmemberdata");
		jsonAsMap.put("aliasName", "");
		jsonAsMap.put("empID", addmemberdata.get(1));
		jsonAsMap.put("employeeCategoryId", addmemberdata.get(2));
		jsonAsMap.put("firstName", addmemberdata.get(3));
		jsonAsMap.put("lastName", addmemberdata.get(4));
		jsonAsMap.put("mobileNumber", addmemberdata.get(5));
		jsonAsMap.put("isPhysicalCard", false);
		jsonAsMap.put("isVirtualCard", true);
		jsonAsMap.put("employeeCategoryName", addmemberdata.get(6));
		jsonAsMap.put("storeId", 1);
		jsonAsMap.put("locationId", "");
		jsonAsMap.put("emailId", null);

		addmemberrequest = given().spec(requestspecification()).log().all()
				.header("X-Auth-Token", getGlobalValues("Token")).header("Origin","http://demoecms.s3-website.ap-south-1.amazonaws.com")
				.body(jsonAsMap);

	}

	@Then("Add member api will call")
	public void add_member_api_will_call() {

		addmemberresponse = addmemberrequest.when().post("/ecms_portal/enterpriseInvite/v1/createUserCard").then().log()
				.all().spec(responseSpecification()).extract().response().asString();

	}

	@And("Response will be success")
	public void response_will_be_success() {

		JsonPath js = new JsonPath(addmemberresponse);
		String getmsg = js.get("message");
		System.out.println(getmsg);
		  if (getmsg == null && getmsg != "Invite created successfully") {
		        Assert.fail("wrong msg");;
		    }


	}

}
