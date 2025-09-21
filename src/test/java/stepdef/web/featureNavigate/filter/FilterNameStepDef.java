package stepdef.web.featureNavigate.filter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.web.featureNavigate.filterPages.FilterNamePages;
import pages.web.log.login.LoginPage;
import stepdef.web.log.login.LoginStepDef;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilterNameStepDef {

    private final FilterNamePages filterNameAzPages;
    private final LoginPage loginPage;


    public FilterNameStepDef() {
        filterNameAzPages = new FilterNamePages();
        loginPage = new LoginPage();
    }



    @When("click icon logo filter {string}")
    public void clickIconLogoFilter(String arg0) {
        filterNameAzPages.clickFilterSort();
    }



    @And("choose Name \\(A to Z)")
    public void chooseNameAToZ() {
        filterNameAzPages.clickSortAZ();
    }



    @Then("verify product Name \\(A to Z)")
    public void verifyProductNameAToZ() {

        List<String> actualNames = filterNameAzPages.getAllProductNames();

        List<String> expectedNames = new ArrayList<>(actualNames);
        System.out.println("\n" + expectedNames); //melihat hasil urutan

        Collections.sort(expectedNames); //ini adalah untuk mengurutkan abjad

        // Bandingkan
        Assertions.assertEquals(actualNames, expectedNames,
                "Produk tidak terurut A-Z sesuai filter!");


        boolean validateName = filterNameAzPages.validateAz();
        String validateFirstProduct = loginPage.verifyLogin();
        String validateLastProduct = filterNameAzPages.validateSortAz();

        assertTrue(validateName, "Name (A to Z)");
        assertEquals("Sauce Labs Backpack",  validateFirstProduct);
        assertEquals("Test.allTheThings() T-Shirt (Red)",  validateLastProduct);

        System.out.println("result ==== " +validateName+ " ===");
        System.out.println("result ==== " +validateFirstProduct+ " ===");
        System.out.println("result ==== " +validateLastProduct+ " ===");
    }



    @When("choose Name \\(Z to A)")
    public void chooseNameZToA() {
        filterNameAzPages.clickSortZA();
    }



    @Then("verify product Name \\(Z to A)")
    public void verifyProductNameZToA() {

        List<String> actualNames = filterNameAzPages.getAllProductNames();

        List<String> expectedNames = new ArrayList<>(actualNames);
        System.out.println("\n" + expectedNames); //melihat hasil urutan

        Collections.sort(expectedNames.reversed()); //ini adalah untuk mengurutkan abjad

        // Bandingkan
        Assertions.assertEquals(actualNames, expectedNames,
                "Produk tidak terurut A-Z sesuai filter!");


        boolean validateName = filterNameAzPages.getTextZa();
        String validateFirstProduct = loginPage.verifyLogin();
        String validateLastProduct = filterNameAzPages.validateSortAz();

        assertTrue(validateName, "Name (Z to A)");
        assertEquals("Test.allTheThings() T-Shirt (Red)",  validateLastProduct);
        assertEquals("Sauce Labs Backpack",  validateFirstProduct);


        System.out.println("result ==== " +validateName+ " ===");
        System.out.println("result ==== " +validateLastProduct+ " ===");
        System.out.println("result ==== " +validateFirstProduct+ " ===");
    }
}
