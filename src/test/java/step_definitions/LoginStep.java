package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProductPage;
import utilities.DriverSetup;

public class LoginStep {
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();

    public LoginStep() {
    }

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        DriverSetup.getDriver().get(this.loginPage.login_page_url);
    }

    @When("user input valid username and password")
    public void userInputValidUsernameAndPassword() {
        this.loginPage.writeOnByLocator(this.loginPage.username_input_field, "standard_user");
        this.loginPage.writeOnByLocator(this.loginPage.password_input_field, "secret_sauce");
    }

    @And("user click on the login button")
    public void userClickOnTheLoginButton() {
        this.loginPage.clickOnAElement(this.loginPage.login_button);
    }

    @Then("user successfully logged in")
    public void userSuccessfullyLoggedIn() {
        Assert.assertEquals(DriverSetup.getDriver().getCurrentUrl(), this.productPage.product_page_url);
    }
}