package stepdef.web.featureNavigate.homepage.menu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.web.featureNavigate.home.HomePages;

import static org.junit.jupiter.api.Assertions.assertEquals;

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



    @Then("verify new homepage about")
    public void verifyNewHomepageAbout() {
        String verifyFirstText = homePages.verifyAboutFirst();
        String verifySecondText = homePages.verifySecondAbout();
        String verifyThirdText = homePages.verifyThirdAbout();

        assertEquals("Turn quality into a strategic advantage—accelerate outcomes with Sauce AI.",
                verifyFirstText);
        assertEquals("Explore more", verifySecondText);
        assertEquals("Build apps users love with AI-driven quality", verifyThirdText);

        System.out.println("Result : " + verifyFirstText);
        System.out.println("Result : " + verifySecondText);
        System.out.println("Result : " + verifyThirdText);
    }
}
