package com.axyya.axjmsp05assignment.pmp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.axyya.axjmsp05assignment.pmp.dto.Product;

public interface ProductService {

	List<Product> getProducts();

	Product getProductById(long id);

	ResponseEntity<?> addProduct(Product product);

	ResponseEntity<?> updateProduct(Product product);

	void deleteProduct(Long id);
}
