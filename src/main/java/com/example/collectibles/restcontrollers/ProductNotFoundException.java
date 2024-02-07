package com.example.collectibles.restcontrollers;

public class ProductNotFoundException extends RuntimeException{
	
	public ProductNotFoundException(String id) {
		super("Product Id not found: "+id);
	}

}
