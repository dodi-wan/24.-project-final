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
    private WebElement element;

    By elementTwitterLogo = By.xpath("//a[@data-test='social-twitter']");
    By elementFacebookLogo = By.xpath("//a[@data-test='social-facebook']");
    By elementLinkedinLogo = By.xpath("//a[@data-test='social-linkedin']");

    By titleTwitter = By.xpath("//span[contains(text(),'Don’t miss what’s happening')]");
    By titleFacebook = By.xpath("//span[contains(text(),'See more from Sauce Labs')]");

    By joinLinkedin = By.xpath("//p[@class='windows-app-upsell__body font-sans text-sm text-color-text-secondary leading-regular']");
    By titleLinkedin = By.xpath("//p[contains(text(),'LinkedIn is better on the app')]");
    By linkedinApp = By.xpath("//a[normalize-space()='Open the app']");


    public SocialMediaPage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }


    public void twitterXlogo(){
//        try {
//            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementTwitterLogo));
//            element.click();
//        } catch (TimeoutException t){
//            System.out.println("Timeout element not found " + t.getMessage());
//        } catch (Exception e) {
//            System.out.println("error " + e.getMessage());
//        }
        driver.findElement(elementTwitterLogo).click();
    }



    public String validateTwitter() {
        String text= null;
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(titleTwitter));
            text = element.getText();
        } catch (TimeoutException t) {
            System.out.println("timeout " + t.getMessage());
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }
        return text;
    }




    public void facebookLogo(){
//        try{
//            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementFacebookLogo));
//            element.click();
//        } catch (TimeoutException t){
//            System.out.println("Timeout element not found " + t.getMessage());
//        }  catch (Exception e) {
//            System.out.println("error " + e.getMessage());
//        }
        driver.findElement(elementFacebookLogo).click();
    }




    public String validateFacebook() {
        String text = null;
        try{
            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(titleFacebook));
            text = element.getText();
        } catch (TimeoutException t) {
            System.out.println("result " + t.getMessage());
        } catch (Exception e) {
            System.out.println("result " + e.getMessage());
        }
        return text;
    }


    public void linkedinLogo(){
//        try{
//            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementLinkedinLogo));
//            element.click();
//        } catch (TimeoutException t){
//            System.out.println("Timeout element not found " + t.getMessage());
//        }  catch (Exception e) {
//            System.out.println("error " + e.getMessage());
//        }
        driver.findElement(elementLinkedinLogo).click();
    }



    public boolean storeLinkedin() {

        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(joinLinkedin));
            element.getText();
        } catch (TimeoutException t) {
            System.out.println("result " + t.getMessage());
        } catch (Exception e) {
            System.out.println("result " + e.getMessage());
        }
        return true;
    }


    public boolean validateLinkedin() {

        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(titleLinkedin));
            element.getText();
        } catch (TimeoutException t) {
            System.out.println("result " + t.getMessage());
        } catch (Exception e) {
            System.out.println("result " + e.getMessage());
        }
        return true;
    }


    public boolean appLinkedin(){

        try{
            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(linkedinApp));
            element.getText();
        } catch (TimeoutException t) {
            System.out.println("result " + t.getMessage());
        } catch (Exception e) {
            System.out.println("result " + e.getMessage());
        }
        return true;
    }
}
