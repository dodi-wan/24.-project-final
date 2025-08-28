package stepdef.web.featureNavigate.filter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.web.featureNavigate.filterPages.FilterPricePages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterPriceStepDef {


    private FilterPricePages filterPricePages;

    public FilterPriceStepDef(){
        filterPricePages = new FilterPricePages();
    }




    @Then("choose Price \\(low to high)")
    public void choosePriceLowToHigh() {
        filterPricePages.click_low_high();

    }

    @Given("verify product Price \\(low to high)")
    public void verifyProductPriceLowToHigh() {

        List<Double> actualPrice = filterPricePages.getProductPrice();
        List<Double> expectedPrice = new ArrayList<>(actualPrice);
        System.out.println("\n" + expectedPrice); //melihat hasil urutan

        Collections.sort(expectedPrice); //ini adalah untuk mengurutkan abjad

        // Bandingkan
        Assertions.assertEquals(expectedPrice, actualPrice,
                "Price doesn't sort low to high!");


    }

    @And("choose Price \\(high to low)")
    public void choosePriceHighToLow() {
        filterPricePages.click_high_low();
    }

    @Given("verify product Price \\(high to low)")
    public void verifyProductPriceHighToLow() {
        List<Double> actualPrice = filterPricePages.getProductPrice();
        List<Double> expectedPrice = new ArrayList<>(actualPrice);
        System.out.println("\n" + expectedPrice); //melihat hasil urutan

        Collections.sort(expectedPrice.reversed()); //ini adalah untuk mengurutkan abjad

        // Bandingkan
        Assertions.assertEquals(expectedPrice, actualPrice,
                "Price doesn't sort high to low!");
    }
}
