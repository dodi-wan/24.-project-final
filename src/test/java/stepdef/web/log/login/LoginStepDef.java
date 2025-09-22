package stepdef.web.log.login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.web.log.login.LoginPage;

import static helper.driver.Utilities.driver;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginStepDef {

    private final LoginPage loginPage;

    public LoginStepDef(){
        loginPage = new LoginPage();
    }


    @Given("user is on homepage saucedemo")
    public void userIsOnHomepageSaucedemo() {
        String currentUrl = driver.getCurrentUrl();
        if (!currentUrl.contains("saucedemo.com")) {
            driver.get("https://www.saucedemo.com/");
        }
        System.out.println("URL : " + currentUrl);
    }


    @When("user input username {string} and password {string}")
    public void userInputUsernameAndPassword(String username, String password) {
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
    }



    @And("user click button login")
    public void userClickButtonLogin() {
        loginPage.clickButton();
    }



    @Then("verify user already login page saucedemo")
    public void verifyUserAlreadyLoginPageSaucedemo() {
        String validateTitle = loginPage.verifyLogin();
        String validateDesc = loginPage.verifyDesc();
        String validateProduct = loginPage.verifyProduct();

        assertEquals("Sauce Labs Backpack", validateTitle);
        assertEquals("carry.allTheThings() with the sleek, streamlined Sly " +
                "Pack that melds uncompromising style with unequaled laptop and tablet protection.", validateDesc);
        assertEquals("Products", validateProduct);

        System.out.println("Result Log-in\n" + validateTitle + "\n" + validateDesc + "\n" + validateProduct);
        loginPage.verifyLogin();
    }




    @Then("message {string}")
    public void message(String messageExpectation) {
        String messageActual = loginPage.messageButton(messageExpectation);

        assertEquals(messageExpectation, messageActual);
        System.out.println("Result \n" + messageActual);
    }



    @Then("user can see {string}")
    public void userCanSee(String messageExpectation) {
        String messageActual = loginPage.messageButton(messageExpectation);

        assertEquals(messageExpectation, messageActual);
        System.out.println("Result \n" + messageActual);
    }
}
