package pages.web.product.removeCart;

import org.openqa.selenium.By;

import static helper.driver.Utilities.driver;

public class RemoveCartPages {


    By elementRemoveBackpack = By.id("remove-sauce-labs-backpack");
    By elementRemoveBikeLight = By.id("remove-sauce-labs-bike-light");
    By elementRemoveBoltTshirt = By.id("remove-sauce-labs-bolt-t-shirt");
    By elementRemoveFleeceJacket = By.id("remove-sauce-labs-fleece-jacket");
    By elementRemoveOnesie = By.id("remove-sauce-labs-onesie");
    By elementRemoveThisrtRed = By.id("remove-test.allthethings()-t-shirt-(red)");


    public void removeBackPack(){
        driver.findElement(elementRemoveBackpack).click();
    }



    public void removeAllProduct(){
        driver.findElement(elementRemoveBackpack).click();
        driver.findElement(elementRemoveBikeLight).click();
        driver.findElement(elementRemoveBoltTshirt).click();
        driver.findElement(elementRemoveFleeceJacket).click();
        driver.findElement(elementRemoveOnesie).click();
        driver.findElement(elementRemoveThisrtRed).click();
    }
}
