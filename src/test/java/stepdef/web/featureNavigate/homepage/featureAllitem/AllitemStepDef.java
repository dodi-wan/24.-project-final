package stepdef.web.featureNavigate.homepage.featureAllitem;

import io.cucumber.java.en.And;
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



    @And("user click shop cart")
    public void userClickShopCart() {
        allItemPages.shopCartButton();
    }



    @And("click all item button")
    public void clickAllItemButton() {
        allItemPages.allItemButton();
    }



    @Then("see product at shopping cart")
    public void seeProductAtShoppingCart() {
        String ExpectedShopCart = "1";
        assertEquals(ExpectedShopCart, allItemPages.countShopCart());
        System.out.println("Result Shop Cart = " + ExpectedShopCart);
    }


}
