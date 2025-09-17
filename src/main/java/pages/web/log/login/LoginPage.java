package pages.web.log.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helper.driver.Utilities.driver;

public class LoginPage {

    private WebDriverWait wait;
    private WebElement element;


    By elementListUsername = By.xpath("//h4[normalize-space()='Accepted usernames are:']");
    By elementPassword = By.xpath("//h4[normalize-space()='Password for all users:']");
    By elementTitle = By.xpath("(//div[@class='login_logo'])[1]");

    By verifyHomepage = By.xpath("//div[text()='Swag Labs']");
    By username = By.id("user-name");
    By password = By.id("password");
    By button = By.id("login-button");
    By elementVerifyLogin  = By.xpath("//div[text()='Swag Labs']");


    By validateTitle = By.xpath("//div[contains(text(),'Sauce Labs Backpack')]");
    By validateDesc = By.xpath("//div[contains(text(),'carry.allTheThings() with the sleek," +
            " streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.')]");
    By validateProduct = By.xpath("//span[contains(text(),'Products')]");

    By messageLogin (String message) {
        return By.xpath("//*[contains (text (), '" + message + "' )]");
    }




    public String usernameHomepage(){
        String text;

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementListUsername));
        text = element.getText();

        return text;
    }



    public String passwordHomepage() {
        String text;

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementPassword));
        text = element.getText();

        return text;
    }



    public String titleHomepage() {
        String text;

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementTitle));
        text = element.getText();

        return text;
    }


    public void inputUsername(String userName){
        driver.findElement(username).sendKeys(userName);
    }


    public void inputPassword(String passwordUser){
        driver.findElement(password).sendKeys(passwordUser);
    }


    public void clickButton(){
        driver.findElement(button).click();
    }


    public String verifyLogin() {

        String text;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(validateTitle));
        text = element.getText();

        return text;
//        driver.findElement(elementVerifyLogin).isDisplayed();
    }


    public String verifyDesc() {
        String text;

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(validateDesc));
        text = element.getText();

        return text;
    }



    public String verifyProduct() {
        String text;

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(validateProduct));
        text = element.getText();

        return text;
    }


    public String messageButton (String messageButton) {
        String text;

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(messageLogin(messageButton)));
        text = element.getText();
        return text;
    }

}
