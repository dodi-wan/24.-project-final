package pages.web.order;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helper.driver.Utilities.driver;

public class CheckoutPages {


    private WebDriverWait wait;

    By checkout_button = By.id("checkout");

    By firstname_input = By.xpath("//input[@placeholder='First Name']");
    By lastname_input = By.xpath("//input[@placeholder='Last Name']");
    By zip_code_input = By.xpath("//input[@placeholder='Zip/Postal Code']");

    By continue_button = By.id("continue");
    By finish_button = By.id("finish");
    By order_success = By.xpath("//h2[contains(text(),'Thank you for your order!')]");



    public CheckoutPages(){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void checkoutButton(){
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(checkout_button));
            element.click();
        } catch (TimeoutException e) {
            System.out.println("Timeout: element not found " + e.getMessage());
        } catch (Exception e){
            System.out.println("Error element" + e.getMessage());
        }
    }



    public void firstNameInput(String firstname){
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(firstname_input));
            element.sendKeys(firstname);
        } catch (TimeoutException t){
            System.out.println("Timeout not found element " + t.getMessage());
        } catch (Exception e){
            System.out.println("error others");
        }
    }



    public void lastNameInput(String lastname){
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(lastname_input));
            element.sendKeys(lastname);
        } catch (TimeoutException e){
            System.out.println("\nTimeout element not found " + e.getMessage());
        } catch (Exception e){
            System.out.println("Unexpected error " + e.getMessage());
        }
    }



    public void zipCodeInput(String zipCode){
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(zip_code_input));
            element.sendKeys(zipCode);
        } catch (TimeoutException e){
            System.out.println("\nTimeout element not found " + e.getMessage());
        } catch (Exception e){
            System.out.println("Unexpected error " + e.getMessage());
        }
    }


    public void continueButton(){
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(continue_button));
            element.click();
        } catch (TimeoutException e){
            System.out.println("\nTimeout element not found " + e.getMessage());
        } catch (Exception e){
            System.out.println("Unexpected error " + e.getMessage());
        }
    }


    public void finishButton(){
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(finish_button));
            element.click();
        } catch (TimeoutException e){
            System.out.println("\nTimeout element not found " + e.getMessage());
        } catch (Exception e){
            System.out.println("Unexpected error " + e.getMessage());
        }
    }



    public void orderSuccess(){
        driver.findElement(order_success).isDisplayed();
    }


}

