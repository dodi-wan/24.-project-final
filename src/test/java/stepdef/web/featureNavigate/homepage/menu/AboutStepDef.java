package stepdef.web.featureNavigate.homepage.menu;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.web.featureNavigate.home.HomePages;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AboutStepDef {

    private final HomePages homePages;


    public AboutStepDef() {
        homePages = new HomePages();
    }



    @When("user click {int} strips menu at top-left window")
    public void userClickStripsMenuAtTopLeftWindow(int arg0) {
        homePages.menuHomepage();
    }



    @And("click button About")
    public void clickButtonAbout() throws InterruptedException {
        homePages.aboutButton();
    }



    @Then("verify new homepage about")
    public void verifyNewHomepageAbout() {
        boolean verifyFirstText = homePages.verifyAboutFirst();
        boolean verifySecondText = homePages.verifySecondAbout();
        boolean verifyThirdText = homePages.verifyThirdAbout();

        String textFirst = "Turn quality into a strategic advantage—accelerate outcomes with Sauce AI.";
        String textSecond = "Explore more";
        String textThird = "Build apps users love with AI-driven quality";

        assertTrue(verifyFirstText, textFirst);
        assertTrue(verifySecondText, textSecond);
        assertTrue(verifyThirdText, textThird);

        System.out.println(textFirst + " = " + verifyFirstText);
        System.out.println(textSecond + " = " + verifySecondText);
        System.out.println(textThird + " = " + verifyThirdText);
    }


}
