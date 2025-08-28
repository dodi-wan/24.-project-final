package stepdef.web.log.login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.web.log.login.LoginPage;


public class LoginStepDef {

    private final LoginPage loginPage;

    public LoginStepDef(){
        loginPage = new LoginPage();
    }


    @Given("verify on homepage")
    public void verifyOnHomepage() {
        loginPage.homepage();
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
        loginPage.verifyLogin();
    }
}
