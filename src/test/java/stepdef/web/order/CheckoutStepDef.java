package stepdef.web.order;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.web.order.CheckoutPages;

public class CheckoutStepDef {

    private final CheckoutPages checkoutPages;


    public CheckoutStepDef(){
        checkoutPages = new CheckoutPages();
    }


    @And("click checkout")
    public void clickCheckout(){
        checkoutPages.checkoutButton();
    }


    @And("input {string} {string} {string}")
    public void input(String firstname, String lastname, String zipcode) {
        checkoutPages.firstNameInput(firstname);
        checkoutPages.lastNameInput(lastname);
        checkoutPages.zipCodeInput(zipcode);
    }


    @Then("click continue")
    public void clickContinue() {
        checkoutPages.continueButton();
    }


    @Then("click finish button")
    public void clickFinishButton() {
        checkoutPages.finishButton();
    }


    @Given("can see title {string}")
    public void canSeeTitle(String arg0) {
        checkoutPages.orderSuccess();
    }

}
