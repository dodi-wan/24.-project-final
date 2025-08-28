package pages.web.log.login;

import org.openqa.selenium.By;

import static helper.driver.Utilities.driver;

public class LoginPage {

    By verify_homepage = By.xpath("//div[text()='Swag Labs']");
    By input_username = By.id("user-name");
    By input_password = By.id("password");
    By click_button = By.id("login-button");
    By verify_login  = By.xpath("//div[text()='Swag Labs']");


    public void homepage(){
        driver.findElement(verify_homepage).isDisplayed();
    }


    public void inputUsername(String username){
        driver.findElement(input_username).sendKeys(username);
    }


    public void inputPassword(String password){
        driver.findElement(input_password).sendKeys(password);
    }


    public void clickButton(){
        driver.findElement(click_button).click();
    }


    public void verifyLogin() {
        driver.findElement(verify_login).isDisplayed();
    }

}
