package stepdef.web.featureNavigate.homepage.menu;

import io.cucumber.java.en.And;
import pages.web.featureNavigate.home.HomePages;

public class AboutStepDef {

    private final HomePages homePages;


    public AboutStepDef() {
        homePages = new HomePages();
    }



    @And("click {int} strips menu at top-left window")
    public void clickStripsMenuAtTopLeftWindow(int arg0) {
        homePages.menuHomepage();
    }



    @And("click button About")
    public void clickButtonAbout() throws InterruptedException {
        homePages.aboutButton();
    }


}
