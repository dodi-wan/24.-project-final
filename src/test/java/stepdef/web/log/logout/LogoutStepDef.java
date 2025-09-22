package stepdef.web.log.logout;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.web.log.logout.LogoutPages;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogoutStepDef {

    private static final Logger log = LoggerFactory.getLogger(LogoutStepDef.class);
    private final LogoutPages logoutPages;

    public LogoutStepDef(){
        logoutPages = new LogoutPages();
    }



    @And("user click logout")
    public void userClickLogout() {
        logoutPages.logoutButton();
    }



    @Then("user already on homepage login")
    public void userAlreadyOnHomepageLogin() {
        String actualUsernameText = logoutPages.getTextUsername();
        String actualPassword = logoutPages.getTextPassword();

        assertEquals("Accepted usernames are:", actualUsernameText);
        assertEquals("Password for all users:", actualPassword);

        System.out.println("Result : " + actualUsernameText);
        System.out.println("Result : " + actualPassword);
    }
}
