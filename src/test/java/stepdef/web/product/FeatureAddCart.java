package stepdef.web.product;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.web.product.addCart.AddToCartPages;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeatureAddCart {

    private final AddToCartPages addToCartPages;

    public FeatureAddCart(){
        addToCartPages = new AddToCartPages();
    }



    @When("user click add to cart product")
    public void userClickAddToCartProduct() {
        addToCartPages.adCartBackpack();
    }



    @And("click all add to cart product")
    public void clickAllAddToCartProduct() {
        addToCartPages.adCartBackpack();
        addToCartPages.addCartBikeLight();
        addToCartPages.addCartBoltTshirt();
        addToCartPages.addCartFleeceJacket();
        addToCartPages.addCartOnesie();
        addToCartPages.addCartTshirtRed();
    }



    @Then("verify how many product at shop cart")
    public void verifyHowManyProductAtShopCart() {
        int expectedCart = 6; //yang diklik total 6 produk.
        int actualCart = addToCartPages.getTotalProduct();
        //bandingkan
        Assertions.assertEquals(expectedCart, actualCart, "element in cart not correct");
    }



    @When("user click add to cart product {string} and {string}")
    public void userClickAddToCartProductAnd(String product1, String product2) {
        addToCartPages.addCartBikeLight();
        addToCartPages.addCartTshirtRed();
    }



    @Then("verify has been click remove")
    public void verifyHasBeenClickRemove() {
        String removeBackPack = addToCartPages.getRemoveBackPack();
        assertEquals("Add to cart", removeBackPack);

        System.out.println("Result \n" + removeBackPack);
    }
}
