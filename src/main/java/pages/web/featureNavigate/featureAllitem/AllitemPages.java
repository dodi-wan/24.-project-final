package pages.web.featureNavigate.featureAllitem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static helper.driver.Utilities.driver;

public class AllitemPages {

    By shopCartButton = By.id("shopping_cart_container");
    By allitemButton = By.id("inventory_sidebar_link");
    By elementShoppingCart = By.xpath ("//span[contains(text(),'')]");



    public void shopCartButton(){
        driver.findElement(shopCartButton).click();
    }



    public void allItemButton(){
        driver.findElement(allitemButton).click();
    }



    public String countShopCart() {
        String text;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementShoppingCart));
        text = element.getText();

        return text;
    }
}
