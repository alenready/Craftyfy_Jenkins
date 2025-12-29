package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CollectionPage;

public class CartT {

	

	public class CartTest extends BaseTest {

	    @Test
	    public void validateCartItemQuantityAndRemove() {

	        //  Step 1: Open collection page
	        driver.get("https://craftyfy-frontend.vercel.app/collection");

	        CollectionPage collection = new CollectionPage(driver);

	        // Step 2: Add item to cart
	        collection.clickProduct();
	        collection.selectRedColor();
	        collection.clickAddToCart();

	        //  Step 3: Open cart
	        CartPage cart = new CartPage(driver);
	        cart.openCart();

	        //  Step 4: Validate item present
	        Assert.assertTrue(cart.isItemVisibleInCart(),
	                "Item not visible in cart");

	        //  Step 5: Increase quantity
	        int initialQty = cart.getQuantity();
	        cart.increaseQuantity();

	        Assert.assertTrue(cart.getQuantity() > initialQty,
	                "Quantity did not increase");

	        //  Step 6: Decrease quantity
	        cart.decreaseQuantity();

	        Assert.assertEquals(cart.getQuantity(), initialQty,
	                "Quantity did not decrease correctly");

	        //  Step 7: Remove item
	        cart.removeItem();

	        //  Step 8: Validate empty cart
	        Assert.assertTrue(cart.isCartEmpty(),
	                "Cart is not empty after removal");
	    }
	}

	
	
	
}
