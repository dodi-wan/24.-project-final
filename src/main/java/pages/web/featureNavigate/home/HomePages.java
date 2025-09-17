package pages.web.featureNavigate.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helper.driver.Utilities.driver;

public class HomePages {

    private WebDriverWait wait;
    private WebElement element;

    By menuHomepage = By.id("react-burger-menu-btn");
    By aboutButton = By.id("about_sidebar_link");

    By elementFirstAbout = By.xpath("//p[contains(text(),'Turn quality into a strategic advantage—accelerate')]");
    By elementSecondAbout = By.xpath("(//span[@class='MuiTypography-root MuiTypography-body3 css-2mjmhh'])[1]");
    By elementThirdAbout = By.xpath("(//h1[normalize-space()='Build apps users love with AI-driven quality'])[1]");



    public void menuHomepage(){
        driver.findElement(menuHomepage).click();
    }


    public void aboutButton() throws InterruptedException {
        driver.findElement(aboutButton).click();
    }

    public String verifyAboutFirst() {
        String text;

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementFirstAbout));
        text = element.getText();
        return text;
    }



    public  String verifySecondAbout() {
        String text;

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementSecondAbout));
        text = element.getText();
        return text;
    }


    public  String verifyThirdAbout() {
        String text;

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementThirdAbout));
        text = element.getText();
        return text;
    }
}
