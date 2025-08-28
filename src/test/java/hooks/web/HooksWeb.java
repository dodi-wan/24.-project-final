package hooks.web;

import helper.driver.Utilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static helper.driver.Utilities.driver;
import static helper.driver.Utilities.startDriver;

public class HooksWeb {


    @Before
    public void setUp() {
        System.out.println("\n===Before===\n");
        if (driver == null) {
        startDriver();
        driver.get("https://www.saucedemo.com/");
        }
    }


    @After
    public void tearDown() throws InterruptedException {
        System.out.println("\n===After===\n");
        Utilities driver = new Utilities();
        Thread.sleep(5000);
        driver.closeDriver();
    }


}
