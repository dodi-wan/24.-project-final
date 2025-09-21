package pages.web.featureNavigate.filterPages;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static helper.driver.Utilities.driver;

public class FilterNamePages {

    private WebDriverWait wait;
    private WebElement element;

    By filterSort = By.className("product_sort_container");
    By productName = By.className("inventory_item_name");

    By sortAz = By.xpath("//option[text()='Name (A to Z)']");
    By sortZa = By.xpath("//option[text()='Name (Z to A)']");

    By aZvalidate = By.xpath("//span[contains(text(),'Name (A to Z)')]");
    By zAvalidate = By.xpath("//span[contains(text(),'Name (Z to A)')]");

    By azSortValidate = By.xpath("//div[contains(text(),'Test.allTheThings() T-Shirt (Red)')]");




    public FilterNamePages(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }



    public void clickFilterSort() {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(filterSort));
            element.click();
        } catch (TimeoutException t) {
            System.out.println("Timeout exception " + t.getMessage());
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }
    }



    public void clickSortAZ(){
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(sortAz));
            element.click();
        } catch (TimeoutException t){
            System.out.println("Timeout exception " + t.getMessage());
        } catch (Exception e){
            System.out.println("error " + e.getMessage());
        }
    }



    public boolean validateAz() {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(aZvalidate));
            element.getText();
        } catch (TimeoutException t) {
            System.out.println("Time out : " + t.getMessage());
        } catch (Exception e) {
            System.out.println("Expect : " + e.getMessage());
        }
        return true;
    }



    public String validateSortAz() {
        String text;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(azSortValidate));
        text = element.getText();

        return text;
    }



    public List<String> getAllProductNames() {
        return driver.findElements(productName)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }




    public void clickSortZA(){
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(sortZa));
            element.click();
        } catch (TimeoutException t){
            System.out.println("Timeout exception " + t.getMessage());
        } catch (Exception e){
            System.out.println("error " + e.getMessage());
        }
    }



    public boolean getTextZa() {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(zAvalidate));
            element.getText();
        } catch (TimeoutException t) {
            System.out.println("Time out : " + t.getMessage());
        } catch (Exception e) {
            System.out.println("Expect : " + e.getMessage());
        }
        return true;
    }


}


