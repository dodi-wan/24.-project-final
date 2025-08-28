package pages.web.featureNavigate.featureAllitem;

import org.openqa.selenium.By;
import static helper.driver.Utilities.driver;

public class All_itemPages {

    By shop_cart_button = By.id("shopping_cart_container");
    By all_item_button = By.id("inventory_sidebar_link");



    public void shopCartButton(){
        driver.findElement(shop_cart_button).click();
    }

    public void allItemButton(){
        driver.findElement(all_item_button).click();
    }
}
