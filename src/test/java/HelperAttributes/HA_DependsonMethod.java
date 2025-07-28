package HelperAttributes;

import org.testng.Reporter;
import org.testng.annotations.Test;
//In dependsonmethod, only if add to cart is present we can update cart and delete cart
//Update and deletecart depends on add to cart method
public class HA_DependsonMethod {
@Test(enabled = false)
public void addtocart() {
	Reporter.log("created addtocart",true);
}
@Test(dependsOnMethods = "addtocart")
public void updatecart() {
	Reporter.log("created updatecart",true);
}
@Test(dependsOnMethods = "addtocart")
public void deletecart() {
	Reporter.log("created delete cart",true);
}
}
