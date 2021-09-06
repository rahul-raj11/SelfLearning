package AmazonImplementation;

public class Search {
	
	public String displayProduct(Product product) {
		
		if(product.getProductList().contains(product.getProduct()))
			return product.getProduct();
		return null;
	}

}
