package stepdef.web.featureNavigate.socialMedia;


import io.cucumber.java.en.When;
import pages.web.featureNavigate.socialMedia.SocialMediaPage;

public class SocialMediaStepDef {

    private final SocialMediaPage socialMediaPage;

    public SocialMediaStepDef(){
        socialMediaPage = new SocialMediaPage();
    }


    @When("click icon twitter")
    public void clickIconTwitter() {
        socialMediaPage.twitterXlogo();
    }


    @When("click icon facebook")
    public void clickIconFacebook() {
        socialMediaPage.facebookLogo();
    }


    @When("click icon linkedin")
    public void clickIconLinkedin() {
        socialMediaPage.linkedinLogo();
    }


}
