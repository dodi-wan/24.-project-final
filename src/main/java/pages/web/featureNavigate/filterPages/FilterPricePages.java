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

public class FilterPricePages {

    private WebDriverWait wait;

    By elementProductPrice = By.className("inventory_item_price");
    By elementLowHigh = By.xpath("//option[text()='Price (low to high)']");
    By elementHighLow = By.xpath("//option[text()='Price (high to low)']");



    public FilterPricePages(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }


    public void click_low_high(){
        try{
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementLowHigh));
        element.click();

        } catch (TimeoutException t) {
            System.out.println("Timeout : not found element " + t.getMessage());
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }
    }


    public List<Double> getProductPrice(){
        return driver.findElements(elementProductPrice)
                .stream()
                .map(e ->Double.parseDouble(e.getText().replace("$", "").trim()))
                .collect(Collectors.toList());
    }


    public void click_high_low(){
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementHighLow));
            element.click();
        } catch (TimeoutException t){
            System.out.println("Timeout element not found " + t.getMessage());
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }
    }
}
