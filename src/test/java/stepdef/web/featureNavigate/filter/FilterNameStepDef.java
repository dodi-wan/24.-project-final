package stepdef.web.featureNavigate.filter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.web.featureNavigate.filterPages.FilterNamePages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterNameStepDef {

    private final FilterNamePages filterNameAzPages;

    public FilterNameStepDef() {
        filterNameAzPages = new FilterNamePages();
    }


    @And("click icon logo filter {string}")
    public void clickIconLogoFilter(String arg0) {
        filterNameAzPages.clickFilterSort();
    }


    @Then("choose Name \\(A to Z)")
    public void chooseNameAToZ() {
        filterNameAzPages.clickSortAZ();
    }


    @Given("verify product Name \\(A to Z)")
    public void verifyProductNameAToZ() {

        List<String> actualNames = filterNameAzPages.getAllProductNames();

        List<String> expectedNames = new ArrayList<>(actualNames);
        System.out.println("\n" + expectedNames); //melihat hasil urutan

        Collections.sort(expectedNames); //ini adalah untuk mengurutkan abjad

        // Bandingkan
        Assertions.assertEquals(actualNames, expectedNames,
                "Produk tidak terurut A-Z sesuai filter!");
    }


    @And("choose Name \\(Z to A)")
    public void chooseNameZToA() {
        filterNameAzPages.clickSortZA();
    }


    @Given("verify product Name \\(Z to A)")
    public void verifyProductNameZToA() {

        List<String> actualNames = filterNameAzPages.getAllProductNames();

        List<String> expectedNames = new ArrayList<>(actualNames);
        System.out.println("\n" + expectedNames); //melihat hasil urutan

        Collections.sort(expectedNames.reversed()); //ini adalah untuk mengurutkan abjad

        // Bandingkan
        Assertions.assertEquals(actualNames, expectedNames,
                "Produk tidak terurut A-Z sesuai filter!");
    }
}
