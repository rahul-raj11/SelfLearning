package stepdefinations;

import AmazonImplementation.Product;
import AmazonImplementation.Search;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class SearchSteps {
	Product product;
	Search search;
	
	@Given("I have a search feild on Amazon page")
	public void i_have_a_search_feild_on_amazon_page() {
		System.out.println("Step 1: I am on search page");
	}

	@When("I search for a product with name {string} and price {int}")
	public void i_search_for_a_product_with_name_and_price(String productName, Integer price) {
		System.out.println("Step 2: Search the product with name: " + productName + " and price: " + price);
		
		product = new Product(productName, price);
	}

	@Then("Product with name {string} should be displayed")
	public void product_with_name_should_be_displayed(String productName) {
		System.out.println("Step 3: Product " + productName + " is displayed");
		
		search = new Search();
		String name = search.displayProduct(product);
		System.out.println("Searched product is: " + name);
		
		Assert.assertEquals(product.getProduct(), name);
	}

}
