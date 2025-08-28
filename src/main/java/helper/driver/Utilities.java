package helper.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Utilities {


    public static WebDriver driver;

    public static void startDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                                "--no-sandbox",
                                "--disable-pop-up-blocking",
                                "--disable-notification",
                                "--start-maximized",
                                "--disable-dev-shm-usage",
                                "--remote-allow-origin=*",
                                "--incognito",
                                "--headless=new"
                );


/*driverManager tugas untuk persiapan peramban dan mengatur, browser chrome digunakan, setup cek versi peramban
* manager mengatur browser chrome dan cek versi nya berapa yang terinstall di lokal cpu dan sesuaikan*/
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options); //driver memiliki objek option
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
    }


    public void closeDriver(){
        driver.quit();
        driver = null;
    }
}
