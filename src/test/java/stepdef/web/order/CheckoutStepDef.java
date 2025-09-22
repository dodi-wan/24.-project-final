package stepdef.web.order;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.web.order.CheckoutPages;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutStepDef {

    private final CheckoutPages checkoutPages;


    public CheckoutStepDef(){
        checkoutPages = new CheckoutPages();
    }


    @And("user click checkout")
    public void userClickCheckout() {
        checkoutPages.checkoutButton();
    }



    @When("user input valid credentials {string} {string} {string}")
    public void userInputValidCredentials(String firstname, String lastname, String zipcode) {
        checkoutPages.firstNameInput(firstname);
        checkoutPages.lastNameInput(lastname);
        checkoutPages.zipCodeInput(zipcode);
    }



    @And("user click continue button")
    public void userClickContinueButton() {
        checkoutPages.continueButton();
    }



    @When("user click finish button")
    public void userClickFinishButton() {
        checkoutPages.finishButton();
    }



    @Given("can see title {string}")
    public void canSeeTitle(String arg0) {
        checkoutPages.orderSuccess();
    }



    @Then("user can see title {string}")
    public void userCanSeeTitle(String expectedMessage) {
        String actualFirstMessage = checkoutPages.messageOrder(expectedMessage);

        assertEquals(expectedMessage, actualFirstMessage);
        System.out.println("Result \n" + actualFirstMessage + "\n");
    }
}
