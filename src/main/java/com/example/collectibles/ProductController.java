package com.example.collectibles;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.async.DeferredResult;

import com.example.collectibles.beans.Filter;
import com.example.collectibles.beans.Product;
import com.example.collectibles.beans.ProductCategory;
import com.example.collectibles.dao.ProductRepository;
import com.example.collectibles.interceptors.ApplicationInterceptor;

@Controller
public class ProductController {
	
	private final Logger logger = LoggerFactory.getLogger(ProductController.class);
	private ProductRepository productRepository;
	private Executor asyncExecutor;
	Logger LOG = LoggerFactory.getLogger(ApplicationInterceptor.class);
	
	public ProductController(ProductRepository productRepository, Executor asyncExecutor) {
		super();
		this.productRepository = productRepository;
		this.asyncExecutor = asyncExecutor;
	}


 	@PostMapping("/search")
	public String search(@RequestParam("searchString") String keyword, Model model) {
		
 		List<Product> products = productRepository.searchByName(keyword);
		
		model.addAttribute("products", products);
		model.addAttribute("searchedFor", keyword);
		
		return "search-results";
	}
 	
 	@GetMapping("/getAllProducts")
 	public DeferredResult<String> getAllProducts(Model model){
 		DeferredResult<String> deferredResult = new DeferredResult<String>();
 		asyncExecutor.execute(()->{
 			model.addAttribute("products", getProducts());
 			model.addAttribute("filter", new Filter());
 			deferredResult.setResult("product-list");
 		});
 		
 		return deferredResult;
 		
 	}
 	
 	private Iterable<Product> getProducts(){
 		
 		logger.info("Getting all products, we are on the spring executor thread");
 		try {
 			Thread.sleep(1000);
 		}catch(InterruptedException e) {
 			throw new RuntimeException();
 		}
 		
 		return productRepository.findAll();
 	}
 	
 	
 	@GetMapping("/getProductDetails")
 	public String getPRoductDetails(Model model, @RequestParam("id") String productID) {
 		model.addAttribute("products", productRepository.searchById(productID));
 		return "product-details";
 	}
 	
 	@PostMapping("/addToCart")
 	public String addToCart(Model model, @SessionAttribute("cart") Map<String, Integer> cart,
 			@RequestParam("productId") String productID, @RequestParam("quantity") Integer quantity) {
 		
 		logger.info("Cart{}",cart);
 		if(!cart.containsKey(productID)) {
 			cart.put(productID, 0);
 		}
 		
 		cart.put(productID, cart.get(productID)+quantity);
 		logger.info("After adding to cart {}",cart);
 		return "redirect:/getProductDetails?id="+productID;
 		
 	}
 	
    @PostMapping("/filterProducts")
    public String filterPRoductsBasedOnProductType(@ModelAttribute("filter") Filter filter, Model model) {
    	
    	List<Product> filteredProducts = new ArrayList<>();
    	List<String> selectedTypes = filter.getSelectedType();
    	for(String token : selectedTypes) {
    		if(token.equals("ALL")) {
    			productRepository.findAll().forEach( product -> {
    				filteredProducts.add(product);
    				});	
    			
    			break;
    	}else {
    		int categoryId = ProductCategory.valueOf(token).getId();
    		filteredProducts.addAll(productRepository.searchByCategoryId(categoryId));
    	}
    	  	
    }
    	model.addAttribute("products", filteredProducts);
    	model.addAttribute("filter", filter);
    	return "product-list";
    	
    }
}
