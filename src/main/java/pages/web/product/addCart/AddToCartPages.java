package pages.web.product.addCart;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helper.driver.Utilities.driver;

public class AddToCartPages {


    private WebDriverWait wait;
    private WebElement element;

    By addBackpack = By.id("add-to-cart-sauce-labs-backpack");
    By addBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    By addBoltTshirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By addFleeceJacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
    By addOnesie = By.id("add-to-cart-sauce-labs-onesie");
    By addThisrtRed = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    By cartBadge = By.className("shopping_cart_badge");

    By titleRemoveBackPack = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/button[1]");



    public AddToCartPages(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }



    public void adCartBackpack(){
        driver.findElement(addBackpack).click();
    }



    public void addCartBikeLight(){
        driver.findElement(addBikeLight).click();
    }



    public void addCartBoltTshirt(){
        driver.findElement(addBoltTshirt).click();
    }



    public void addCartFleeceJacket(){
        driver.findElement(addFleeceJacket).click();
    }



    public void addCartOnesie(){
        driver.findElement(addOnesie).click();
    }



    public void addCartTshirtRed(){
        driver.findElement(addThisrtRed).click();
    }



    public int getTotalProduct(){
        try{
            element = wait.until(ExpectedConditions.elementToBeClickable(cartBadge));
            String BadgeText = element.getText().trim();
            return Integer.parseInt(BadgeText);
        } catch (NoSuchElementException e) {
            System.out.println("element not found " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("Timeout for search element " + e.getMessage());
        }
        return 0;
    }



    public String getRemoveBackPack() {
        String text;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(titleRemoveBackPack));
        text = element.getText();

        return text;
    }
}
