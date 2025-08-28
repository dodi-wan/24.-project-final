package pages.web.product.addCart;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helper.driver.Utilities.driver;

public class AddToCartPages {


    private WebDriverWait wait;

    By add_cart_backpack = By.id("add-to-cart-sauce-labs-backpack");
    By add_bike_light = By.id("add-to-cart-sauce-labs-bike-light");
    By add_bolt_tshirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By add_fleece_jacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
    By add_onesie = By.id("add-to-cart-sauce-labs-onesie");
    By add_thisrt_red = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    By cartbadge = By.className("shopping_cart_badge");


    public AddToCartPages(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    };

    public void adCartBackpack(){
        driver.findElement(add_cart_backpack).click();
    }

    public void addBikeLight(){
        driver.findElement(add_bike_light).click();
    }

    public void addBoltTshirt(){
        driver.findElement(add_bolt_tshirt).click();
    }

    public void addFleeceJacket(){
        driver.findElement(add_fleece_jacket).click();
    }

    public void addOnesie(){
        driver.findElement(add_onesie).click();
    }

    public void addTshirtRed(){
        driver.findElement(add_thisrt_red).click();
    }


    public int getTotalProduct(){
        try{
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(cartbadge));
            String BadgeText = element.getText().trim();
            return Integer.parseInt(BadgeText);
        } catch (NoSuchElementException e) {
            System.out.println("element not found " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("Timeout for search element " + e.getMessage());
        }
        return 0;
    }

}
