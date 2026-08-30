package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import utilities.BaseClass;

public class LoginSteps {

    LoginPage loginPage;

    @Before
    public void setUp() {
        // Driver is initialized in Given step so each scenario starts fresh
    }

    @Given("User is on the Login Page")
    public void user_is_on_the_login_page() {
        BaseClass.initializeDriver();
        loginPage = new LoginPage(BaseClass.driver);
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLogin();
    }

    @Then("User should be navigated to the Dashboard")
    public void user_should_be_navigated_to_the_dashboard() {
        // Success indicators: logout visible OR URL no longer login OR title change
        boolean success = loginPage.isLogoutVisible()
                || !loginPage.getCurrentUrl().toLowerCase().contains("login")
                || loginPage.getPageTitle().toLowerCase().contains("stock");
        Assert.assertTrue(success, "Login failed - Dashboard not loaded. Current URL: "
                + loginPage.getCurrentUrl());
    }

    @Then("Logout link should be visible")
    public void logout_link_should_be_visible() {
        Assert.assertTrue(loginPage.isLogoutVisible(), "Logout link is not visible after login");
    }

    @Then("Error message should be displayed or user stays on Login page")
    public void error_message_should_be_displayed_or_user_stays_on_login_page() {
        boolean stillOnLogin = loginPage.getCurrentUrl().toLowerCase().contains("login");
        boolean errorShown = loginPage.isErrorDisplayed();
        Assert.assertTrue(stillOnLogin || errorShown,
                "Expected to stay on Login page or see error message");
    }

    @After
    public void tearDown() {
        BaseClass.quitDriver();
    }
}
