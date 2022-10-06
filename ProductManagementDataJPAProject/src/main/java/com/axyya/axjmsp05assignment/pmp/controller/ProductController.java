package com.axyya.axjmsp05assignment.pmp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axyya.axjmsp05assignment.pmp.dto.Product;
import com.axyya.axjmsp05assignment.pmp.exception.InvalidProductIDException;
import com.axyya.axjmsp05assignment.pmp.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/productbyId/{id}")
	public Product getProductByID(@PathVariable Long id) {
		return productService.getProductById(id);

	}

	@GetMapping("/getallProducts")
	public List<Product> getAllProducts() {
		return productService.getProducts();
	}

	@PostMapping("/addProduct")
	@ExceptionHandler(InvalidProductIDException.class)
	public ResponseEntity<?> addProducts(@RequestBody Product product) {
		ResponseEntity<?> prod = productService.addProduct(product);

		return prod;
	}

	@PutMapping("/updateProduct")
//	@ExceptionHandler(InvalidProductIDException.class)
	public ResponseEntity<?> updateProducts(@RequestBody Product product) {
		ResponseEntity<?> prod = productService.updateProduct(product);

		return prod;
	}

	@DeleteMapping("/deleteProduct/{id}")
//	@ExceptionHandler(InvalidProductIDException.class)
	public void deleteProducts(@PathVariable long id) {
		productService.deleteProduct(id);

	}
}
