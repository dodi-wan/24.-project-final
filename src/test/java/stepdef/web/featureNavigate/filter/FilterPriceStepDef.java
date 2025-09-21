package stepdef.web.featureNavigate.filter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.web.featureNavigate.filterPages.FilterPricePages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterPriceStepDef {


    private FilterPricePages filterPricePages;

    public FilterPriceStepDef(){
        filterPricePages = new FilterPricePages();
    }



    @And("choose Price \\(low to high)")
    public void choosePriceLowToHigh() {
        filterPricePages.clickLowHigh();
    }



    @Then("verify product Price \\(low to high)")
    public void verifyProductPriceLowToHigh() {

        List<Double> actualPrice = filterPricePages.getProductPrice();
        List<Double> expectedPrice = new ArrayList<>(actualPrice);
        System.out.println("\n" + expectedPrice); //melihat hasil urutan

        Collections.sort(expectedPrice); //ini adalah untuk mengurutkan abjad

        // Bandingkan
        Assertions.assertEquals(expectedPrice, actualPrice,
                "Price doesn't sort low to high!");


        String validateName = filterPricePages.getTextPriceLowHigh();
        String validateFirstPrice = filterPricePages.getFirstPrice();
        String validateLastPrice = filterPricePages.getLastPriceLoHi();

        assertEquals("Price (low to high)", validateName);
        assertEquals("$7.99", validateFirstPrice);
        assertEquals("$49.99", validateLastPrice);

        System.out.println("Result === " +validateName+ " ===" );
        System.out.println("Result === " +validateFirstPrice+ " ===" );
        System.out.println("Result === " +validateLastPrice+ " ===" );
    }




    @And("choose Price \\(high to low)")
    public void choosePriceHighToLow() {
        filterPricePages.clickHighLow();
    }




    @Then("verify product Price \\(high to low)")
    public void verifyProductPriceHighToLow() {
        List<Double> actualPrice = filterPricePages.getProductPrice();
        List<Double> expectedPrice = new ArrayList<>(actualPrice);
        System.out.println("\n" + expectedPrice); //melihat hasil urutan

        Collections.sort(expectedPrice.reversed()); //ini adalah untuk mengurutkan abjad

        // Bandingkan
        Assertions.assertEquals(expectedPrice, actualPrice,
                "Price doesn't sort high to low!");

        String validateName = filterPricePages.getTextPriceHighLow();
        String validateFirstPrice = filterPricePages.getFirstPrice();
        String validateLastPrice = filterPricePages.getLastPriceLoHi();

        assertEquals("Price (high to low)", validateName);
        assertEquals("$49.99", validateFirstPrice);
        assertEquals("$7.99", validateLastPrice);

        System.out.println("Result === " +validateName+ " ===" );
        System.out.println("Result === " +validateFirstPrice+ " ===" );
        System.out.println("Result === " +validateLastPrice+ " ===" );
    }
}
