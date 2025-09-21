package stepdef.web.product;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import pages.web.product.removeCart.RemoveCartPages;

public class RemoveCart {

    private final RemoveCartPages removeCartPages;

    public RemoveCart(){
        removeCartPages = new RemoveCartPages();
    }



    @But("user remove product")
    public void userRemoveProduct() {
        removeCartPages.removeBackPack();
    }



    @Then("remove all product")
    public void removeAllProduct() {
        removeCartPages.removeAllProduct();
    }
}
