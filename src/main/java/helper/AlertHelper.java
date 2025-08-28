package helper;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHelper {

    private WebDriver driver;
    private WebDriverWait wait;

    public AlertHelper(WebDriver driverm, long timeoutInSecond){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSecond));
    }


//untuk menunggu alert muncul
    private Alert waitForAlert(){
        return wait.until(ExpectedConditions.alertIsPresent());
    }


//untuk accept alert
    public void acceptAlert(){
        waitForAlert().accept();
    }


//ambil text alert
    public String getTextAlert(){
        return waitForAlert().getText();
    }
}
