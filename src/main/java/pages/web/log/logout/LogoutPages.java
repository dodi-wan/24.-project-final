package pages.web.log.logout;

import org.openqa.selenium.By;

import static helper.driver.Utilities.driver;

public class LogoutPages {

    By logout = By.id("logout_sidebar_link");

    By elementListUsername = By.xpath("//h4[normalize-space()='Accepted usernames are:']");
    By elementPassword = By.xpath("//h4[normalize-space()='Password for all users:']");



    public void logoutButton(){
        driver.findElement(logout).click();
    }



    public String getTextUsername() {
        String text;
        text = driver.findElement(elementListUsername).getText();
        return text;
    }



    public String getTextPassword() {
        String text;
        text = driver.findElement(elementPassword).getText();
        return text;
    }
}
