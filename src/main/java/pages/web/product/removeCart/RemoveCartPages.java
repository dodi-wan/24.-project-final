package pages.web.product.removeCart;

import org.openqa.selenium.By;

import static helper.driver.Utilities.driver;

public class RemoveCartPages {


    By remove_backpack = By.id("remove-sauce-labs-backpack");
    By remove_bike_light = By.id("remove-sauce-labs-bike-light");
    By remove_bolt_tshirt = By.id("remove-sauce-labs-bolt-t-shirt");
    By remove_fleece_jacket = By.id("remove-sauce-labs-fleece-jacket");
    By remove_onesie = By.id("remove-sauce-labs-onesie");
    By remove_thisrt_red = By.id("remove-test.allthethings()-t-shirt-(red)");


    public void removeBackPack(){
        driver.findElement(remove_backpack).click();
    }

    public void removeAllProduct(){
        driver.findElement(remove_backpack).click();
        driver.findElement(remove_bike_light).click();
        driver.findElement(remove_bolt_tshirt).click();
        driver.findElement(remove_fleece_jacket).click();
        driver.findElement(remove_onesie).click();
        driver.findElement(remove_thisrt_red).click();
    }
}
