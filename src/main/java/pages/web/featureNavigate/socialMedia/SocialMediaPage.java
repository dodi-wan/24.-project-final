package pages.web.featureNavigate.socialMedia;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helper.driver.Utilities.driver;

public class SocialMediaPage {

    private WebDriverWait wait;

    By twitterX_logo = By.xpath("//a[@data-test='social-twitter']");
    By facebook_logo = By.xpath("//a[@data-test='social-facebook']");
    By linkedin_logo = By.xpath("//a[@data-test='social-linkedin']");


    public SocialMediaPage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }


    public void twitterXlogo(){
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(twitterX_logo));
            element.click();
        } catch (TimeoutException t){
            System.out.println("Timeout element not found " + t.getMessage());
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }
    }


    public void facebookLogo(){
        try{
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(facebook_logo));
            element.click();
        } catch (TimeoutException t){
            System.out.println("Timeout element not found " + t.getMessage());
        }  catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }
    }


    public void linkedinLogo(){
        try{
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(linkedin_logo));
            element.click();
        } catch (TimeoutException t){
            System.out.println("Timeout element not found " + t.getMessage());
        }  catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }
    }
}
