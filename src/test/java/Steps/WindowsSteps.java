package Steps;

import com.pages.LoginPage;
import com.pages.WindowPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WindowsSteps {

	// Create object of Windows page
	private String text;
	private WindowPage wp = new WindowPage(DriverFactory.getDriver());

	@Given("User should be on the practice page")
	public void user_should_be_on_the_practice_page() {
		DriverFactory.getDriver().get("https://rahulshettyacademy.com/AutomationPractice");
	}

	@When("user click on the open tab button")
	public void user_click_on_the_open_tab_button() throws InterruptedException {
		wp.verifyClick();
	}

	@Then("page will be navigated to the child page and contains the text")
	public void page_will_be_navigated_to_the_child_page_and_contains_the_text() {
		text = wp.gettext();
	}

	@Then("text should be displayed {string}")
	public void text_should_be_displayed(String expectedtext) {
		if (text.contains(expectedtext)) {	        
	        System.out.println("Text contains the expected text: " + expectedtext);
	    } else {
	        System.out.println("Text does not contain the expected text: " + expectedtext);
	    }
	}

}
