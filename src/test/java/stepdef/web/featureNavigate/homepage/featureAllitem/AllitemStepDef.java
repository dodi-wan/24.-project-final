package stepdef.web.featureNavigate.homepage.featureAllitem;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.web.featureNavigate.featureAllitem.AllitemPages;
import pages.web.log.login.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AllitemStepDef {

    private AllitemPages allItemPages;
    private LoginPage loginPage;


    public AllitemStepDef(){
        allItemPages = new AllitemPages();
        loginPage = new LoginPage();
    }



    @When("click shop cart")
    public void clickShopCart() {
        allItemPages.shopCartButton();
    }



    @Then("click all item button")
    public void clickAllItemButton() {
        allItemPages.allItemButton();
    }



    @Given("verify all item button")
    public void verifyAllItemButton() {
        String validateTitle = loginPage.verifyLogin();
        String validateDesc = loginPage.verifyDesc();
        String validateProduct = loginPage.verifyProduct();

        assertEquals("Sauce Labs Backpack", validateTitle);
        assertEquals("carry.allTheThings() with the sleek, streamlined Sly " +
                "Pack that melds uncompromising style with unequaled laptop and tablet protection.", validateDesc);
        assertEquals("Products", validateProduct);

        System.out.println("Result Log-in\n" + validateTitle + "\n" + validateDesc + "\n" + validateProduct);
    }




    @Then("see product at shopping cart")
    public void seeProductAtShoppingCart() {
        assertEquals("1", allItemPages.countShopCart());
    }
}
