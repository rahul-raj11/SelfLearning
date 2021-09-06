package AmazonImplementation;

import java.util.ArrayList;
import java.util.List;

public class Product {
	
	private String productName;
	private int price;
	
	public Product(String product, int price) {
		super();
		this.productName = product;
		this.price = price;
	}

	public String getProduct() {
		return productName;
	}

	public void setProduct(String product) {
		this.productName = product;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public List<String> getProductList() {
		List<String> productList = new ArrayList<>();
		productList.add("Apple MacBook Pro");
		productList.add("Apple MacBook Air");
		productList.add("Apple iPhone 12");
		return productList;
	}
	
	

}
