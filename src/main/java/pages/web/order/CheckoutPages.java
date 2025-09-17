package pages.web.order;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helper.driver.Utilities.driver;

public class CheckoutPages {


    private WebDriverWait wait;
    private WebElement element;

    By buttonCheckout = By.id("checkout");

    By inputFirstname = By.xpath("//input[@placeholder='First Name']");
    By inputLastname = By.xpath("//input[@placeholder='Last Name']");
    By inputZipCode = By.xpath("//input[@placeholder='Zip/Postal Code']");

    By buttonContinue = By.id("continue");
    By buttonFinish = By.id("finish");

    By messageOrderSuccess = By.xpath("//h2[contains(text(),'Thank you for your order!')]");

    By orderMessage (String message) {
        return By.xpath("//*[contains (text (), '" + message + "' )]");
    }



    public CheckoutPages(){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void checkoutButton(){
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(buttonCheckout));
            element.click();
        } catch (TimeoutException e) {
            System.out.println("Timeout: element not found " + e.getMessage());
        } catch (Exception e){
            System.out.println("Error element" + e.getMessage());
        }
    }



    public void firstNameInput(String firstname){
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(inputFirstname));
            element.sendKeys(firstname);
        } catch (TimeoutException t){
            System.out.println("Timeout not found element " + t.getMessage());
        } catch (Exception e){
            System.out.println("error others");
        }
    }



    public void lastNameInput(String lastname){
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(inputLastname));
            element.sendKeys(lastname);
        } catch (TimeoutException e){
            System.out.println("\nTimeout element not found " + e.getMessage());
        } catch (Exception e){
            System.out.println("Unexpected error " + e.getMessage());
        }
    }



    public void zipCodeInput(String zipCode){
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(inputZipCode));
            element.sendKeys(zipCode);
        } catch (TimeoutException e){
            System.out.println("\nTimeout element not found " + e.getMessage());
        } catch (Exception e){
            System.out.println("Unexpected error " + e.getMessage());
        }
    }


    public void continueButton(){
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(buttonContinue));
            element.click();
        } catch (TimeoutException e){
            System.out.println("\nTimeout element not found " + e.getMessage());
        } catch (Exception e){
            System.out.println("Unexpected error " + e.getMessage());
        }
    }


    public void finishButton(){
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(buttonFinish));
            element.click();
        } catch (TimeoutException e){
            System.out.println("\nTimeout element not found " + e.getMessage());
        } catch (Exception e){
            System.out.println("Unexpected error " + e.getMessage());
        }
    }



    public void orderSuccess(){
        driver.findElement(messageOrderSuccess).isDisplayed();
    }



    public String messageOrder(String message){
        String text;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(orderMessage(message)));
        text = element.getText();

        return text;
    }


}

