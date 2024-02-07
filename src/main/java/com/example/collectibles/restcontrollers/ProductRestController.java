package com.example.collectibles.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.collectibles.dao.ProductRepository;
import com.example.collectibles.beans.Product;

@RestController
public class ProductRestController {
	
	private ProductRepository productRepository;
	
	
	
	public ProductRestController(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}



	/*@GetMapping("/bigstar/api/products")
	public List<Product> allProducts(){
		List<Product> productList = new ArrayList<Product>();
		Iterable<Product> products = productRepository.findAll();
		
		products.forEach(product->{
			productList.add(product);
		}); 
		
		return productList;
	}*/
	
	@GetMapping("/bigstar/api/products/{id}")
	public Product getProductById(@PathVariable("id") String id) {
		return productRepository.findById(Integer.valueOf(id)).orElseThrow(
				
				()->new ProductNotFoundException(id)
				);
	}
	
	@PostMapping("/bigstar/api/products")
	public Product saveProduct(@RequestBody Product newProduct) {
		return productRepository.findById(newProduct.getId()).map(product -> {
			product.setName(newProduct.getName());
			product.setDescription(newProduct.getDescription());
			product.setColor(newProduct.getColor());
			//product.setCategory_id(newProduct.getCategory_id());
			product.setRobotID(newProduct.getRobotID());
			product.setImagePath(newProduct.getImagePath());
			product.setRating(newProduct.getRating());
			product.setNoOfReviews(newProduct.getNoOfReviews());
			product.setPrice(newProduct.getPrice());
			
			return productRepository.save(product);
		}).orElseGet( ()->{
			return productRepository.save(newProduct);
		});		
	}
	

	
	@GetMapping("/bigstar/api/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		return new ResponseEntity(Streamable.of(productRepository.findAll()).stream().toList(), HttpStatus.OK);
	}
	

}
