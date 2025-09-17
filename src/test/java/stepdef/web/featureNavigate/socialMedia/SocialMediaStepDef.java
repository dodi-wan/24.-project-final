package stepdef.web.featureNavigate.socialMedia;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.web.featureNavigate.socialMedia.SocialMediaPage;

import static helper.driver.Utilities.driver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SocialMediaStepDef {

    private final SocialMediaPage socialMediaPage;
    private String trueWindow;

    public SocialMediaStepDef(){
        socialMediaPage = new SocialMediaPage();
    }


    @When("click icon twitter")
    public void clickIconTwitter() {

        trueWindow = driver.getWindowHandle();
        socialMediaPage.twitterXlogo();

        for (String windowTwitter : driver.getWindowHandles()) {
            if (!windowTwitter.equals(trueWindow)) {
                driver.switchTo().window(windowTwitter);
                break;
            }
        }
    }



    @Then("verify homepage twitter")
    public void verifyHomepageTwitter() {
        String validateTitle = socialMediaPage.validateTwitter();
        assertEquals("Don’t miss what’s happening", validateTitle);
        System.out.println("Result ===" + validateTitle + "===");
    }




    @When("click icon facebook")
    public void clickIconFacebook() {
        trueWindow = driver.getWindowHandle();
        socialMediaPage.facebookLogo();

        for (String windowFacebook : driver.getWindowHandles()) {
            if (!windowFacebook.equals(trueWindow)) {
                driver.switchTo().window(windowFacebook);
                break;
            }
        }
    }



    @Then("verify homepage facebook")
    public void verifyHomepageFacebook() {
        String validateTitle = socialMediaPage.validateFacebook();

        assertEquals("See more from Sauce Labs", validateTitle);
        System.out.println("Result === " + validateTitle + " ===");
    }



    @When("click icon linkedin")
    public void clickIconLinkedin() {
        trueWindow = driver.getWindowHandle();
        socialMediaPage.linkedinLogo();

        for(String windowLinkedin : driver.getWindowHandles()){
            if(!windowLinkedin.equals(trueWindow)){
                driver.switchTo().window(windowLinkedin);
                break;
            }
        }
    }




    @Then("verify homepage linkedin")
    public void verifyHomepageLinkedin() {
        boolean validateStoreLinkedin = socialMediaPage.storeLinkedin();
        boolean validateTitle = socialMediaPage.validateLinkedin();
        boolean validateAppLinkedin = socialMediaPage.appLinkedin();

        assertTrue(validateStoreLinkedin, "Don’t have the app? Get it in the Microsoft Store.");
        assertTrue(validateTitle, "LinkedIn is better on the app");
        assertTrue(validateAppLinkedin, "Open the app");

        System.out.println("Result === " + validateStoreLinkedin + " ===");
        System.out.println("Result === " + validateTitle + " ===");
        System.out.println("Result === " + validateAppLinkedin + " ===");
    }
}
