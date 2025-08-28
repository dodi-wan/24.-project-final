package stepdef.web.product;

import io.cucumber.java.en.Then;
import pages.web.product.removeCart.RemoveCartPages;

public class RemoveCart {

    private final RemoveCartPages removeCartPages;

    public RemoveCart(){
        removeCartPages = new RemoveCartPages();
    }



    @Then("remove product")
    public void removeProduct() {
        removeCartPages.removeBackPack();
    }

    @Then("remove all product")
    public void removeAllProduct() {
        removeCartPages.removeAllProduct();
    }
}
