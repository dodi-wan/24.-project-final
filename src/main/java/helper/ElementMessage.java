package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementMessage {

    private WebDriver driver;
    private WebDriverWait wait;



    public ElementMessage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }



    public String messageLocator(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.getText();

        } catch (Exception e) {
            System.out.println("element tidak ditemukan " + e.getMessage() + "/n" + locator.toString());
            return null;
        }
    }
}