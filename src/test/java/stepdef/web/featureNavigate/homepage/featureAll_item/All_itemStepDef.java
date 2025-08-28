package stepdef.web.featureNavigate.homepage.featureAll_item;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.web.featureNavigate.featureAllitem.All_itemPages;

public class All_itemStepDef {

    private All_itemPages allItemPages;


    public All_itemStepDef(){
        allItemPages = new All_itemPages();
    }


    @When("click shop cart")
    public void clickShopCart() {
        allItemPages.shopCartButton();
    }


    @Then("click all item button")
    public void clickAllItemButton() {
        allItemPages.allItemButton();
    }
}
