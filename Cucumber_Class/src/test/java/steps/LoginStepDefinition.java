package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition {

	@Given("^User is on Techfios login page$")

	public void user_is_on_techfios_login_page() {

	}

	@When("^User enters username as \"([^\"]*)\"$")

	public void user_enters_username_as(String username) {

	}

	@When("^User enters password as \"([^\"]*)\"$")
	public void user_enters_password_as(String arg1) throws Throwable {

	}

	@When("^User clicks signin button$")
	public void user_clicks_signin_button() throws Throwable {

	}

	@Then("^User should land on dashboard page$")
	public void user_should_land_on_dashboard_page() throws Throwable {

	}

}
