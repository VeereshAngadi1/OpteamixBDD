package Steps;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	// Create object of login page
	private static String title;
	private LoginPage lp = new LoginPage(DriverFactory.getDriver());

	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = lp.getLoginPageTitle();
		System.out.println(title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedstring) {
		Assert.assertTrue(title.contains(expectedstring));

	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() throws InterruptedException {
		Assert.assertTrue(lp.isForgotPwdLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) throws InterruptedException {
		lp.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) throws InterruptedException {
		lp.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		lp.clickOnLogin();
	}

}
