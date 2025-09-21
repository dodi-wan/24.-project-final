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
    private WebElement element;

    By elementProductPrice = By.className("inventory_item_price");
    By elementLowHigh = By.xpath("//option[text()='Price (low to high)']");
    By elementHighLow = By.xpath("//option[text()='Price (high to low)']");

    By sortPriceLohi = By.xpath("//option[contains (@value, 'lohi')]");
    By sortPriceHilo = By.xpath("//option[contains (@value, 'hilo')]");

    By loHiFirstPrice = By.xpath("//div[@class='inventory_list']//div[1]//div[2]//div[2]//div[1]");
    By loHiLastPrice = By.xpath("//*[@id='inventory_container']/div/div[6]/div[2]/div[2]/div");



    public FilterPricePages(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }


    public void clickLowHigh(){
        try{
        element = wait.until(ExpectedConditions.elementToBeClickable(elementLowHigh));
        element.click();

        } catch (TimeoutException t) {
            System.out.println("Timeout : not found element " + t.getMessage());
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }
    }



    public String getTextPriceLowHigh() {
        String text;
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(sortPriceLohi));
        text = element.getText();

        return text;
    }


    public List<Double> getProductPrice(){
        return driver.findElements(elementProductPrice)
                .stream()
                .map(e ->Double.parseDouble(e.getText().replace("$", "").trim()))
                .collect(Collectors.toList());
    }



    public String getFirstPrice() {
        String text;
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(loHiFirstPrice));
        text = element.getText();

        return text;
    }



    public String getLastPriceLoHi() {
        String text;
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(loHiLastPrice));
        text = element.getText();

        return text;
    }


    public void clickHighLow(){
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementHighLow));
            element.click();
        } catch (TimeoutException t){
            System.out.println("Timeout element not found " + t.getMessage());
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
        }
    }



    public String getTextPriceHighLow() {
        String text;
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(sortPriceHilo));
        text = element.getText();

        return text;
    }


}
