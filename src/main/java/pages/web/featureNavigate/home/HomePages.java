package pages.web.featureNavigate.home;

import org.openqa.selenium.By;

import static helper.driver.Utilities.driver;

public class HomePages {

    By menu_homepage = By.id("react-burger-menu-btn");
    By about_button = By.id("about_sidebar_link");



    public void menuHomepage(){
        driver.findElement(menu_homepage).click();
    }


    public void aboutButton() throws InterruptedException {
        driver.findElement(about_button).click();
        Thread.sleep(5);
        driver.navigate().back();
    }
}
