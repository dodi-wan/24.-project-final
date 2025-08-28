package stepdef.web.log.logout;

import io.cucumber.java.en.Then;
import pages.web.log.logout.LogoutPages;

public class LogoutStepDef {

    private final LogoutPages logoutPages;

    public LogoutStepDef(){
        logoutPages = new LogoutPages();
    }


    @Then("click logout")
    public void clickLogout() {
        logoutPages.logoutButton();
    }
}
