package pages.web.featureNavigate.filterPages;


import helper.driver.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static helper.driver.Utilities.driver;

public class FilterNamePages {

    private WebDriverWait wait;

    By click_filter_sort = By.className("product_sort_container");
    By product_name = By.className("inventory_item_name");
    By sort_A_Z = By.xpath("//option[text()='Name (A to Z)']");
    By sort_Z_A = By.xpath("//option[text()='Name (Z to A)']");



    public FilterNamePages(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }


    public void clickFilterSort() {

        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(click_filter_sort));
            element.click();
        } catch (TimeoutException t) {
            System.out.println("Timeout exception " + t.getMessage());
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }
    }


    public void clickSortAZ(){

        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(sort_A_Z));
            element.click();
        } catch (TimeoutException t){
            System.out.println("Timeout exception " + t.getMessage());
        } catch (Exception e){
            System.out.println("error " + e.getMessage());
        }
    }


    public List<String> getAllProductNames() {
        return driver.findElements(product_name)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }



    public void clickSortZA(){
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(sort_Z_A));
            element.click();
        } catch (TimeoutException t){
            System.out.println("Timeout exception " + t.getMessage());
        } catch (Exception e){
            System.out.println("error " + e.getMessage());
        }
    }


}


