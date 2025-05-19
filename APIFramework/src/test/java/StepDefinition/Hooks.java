package StepDefinition;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@FetchTeams")
	
	public void beforescenario() throws IOException {
		
    StepDefination m = new StepDefination();
      m.email_id_and_password();
      m.user_will_using_email_id_and_password_with_api_using_method("resource", "method");
      m.api_will_automatically_call_for_virtual_account_details_with_code(null, null);
      m.will_fetch_in_account_details(null);
}
}
