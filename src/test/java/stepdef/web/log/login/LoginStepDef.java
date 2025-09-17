package stepdef.web.log.login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.web.log.login.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginStepDef {

    private final LoginPage loginPage;

    public LoginStepDef(){
        loginPage = new LoginPage();
    }


    @Given("verify on homepage")
    public void verifyOnHomepage() {
        String username = loginPage.usernameHomepage();
        String password = loginPage.passwordHomepage();
        String title = loginPage.titleHomepage();

        assertEquals("Accepted usernames are:", username);
        assertEquals("Password for all users:", password);
        assertEquals("Swag Labs", title);

        System.out.println("Result \n" + username + "\n" + password + "\n" + title);
    }



    @And("input {string} and {string}")
    public void inputAnd(String username, String password) {
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
    }



    @Then("click button login")
    public void clickButtonLogin() {
        loginPage.clickButton();
    }



    @Given("verify login")
    public void verifyLogin() {
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
}
