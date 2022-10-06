package com.axyya.axjmsp05assignment.pmp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.axyya.axjmsp05assignment.pmp.dto.Product;
import com.axyya.axjmsp05assignment.pmp.exception.InvalidProductIDException;
import com.axyya.axjmsp05assignment.pmp.repository.ProductRepository;
import com.axyya.axjmsp05assignment.pmp.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public Product getProductById(long id) {
		Optional<Product> exisitingProduct = productRepository.findById(id);
		if (exisitingProduct.isPresent()) {
			return exisitingProduct.get();
		} else {
			throw new InvalidProductIDException("Product id " + id + " is not found.");
		}

	}

	@Override
	public List<Product> getProducts() {
		List<Product> products = (List<Product>) productRepository.findAll();
		return products;
	}

	@Override
	public ResponseEntity<?> addProduct(Product product) {
		Optional<Product> exisitingProduct = productRepository.findById(product.getId());
		if (!exisitingProduct.isPresent()) {
			productRepository.save(product);
			return new ResponseEntity<Product>(product,HttpStatus.OK);
		} else {
			throw new InvalidProductIDException("Product details with id " + product.getId() + " is already present.");
		}
		
	}

	@Override
	public ResponseEntity<?> updateProduct(Product product) {
		Optional<Product> exisitingProduct = productRepository.findById(product.getId());
		if (exisitingProduct.isPresent()) {
			productRepository.save(product);
			return new ResponseEntity<Product>(product,HttpStatus.CREATED);

		} else {
			throw new InvalidProductIDException("Product with code " + product.getId()
					+ " is Not Found. Please try to update with correct Product ID.");
		}

	}

	@Override
	public void deleteProduct(@PathVariable Long id) {
		Optional<Product> exisitingProduct = productRepository.findById(id);

		if (exisitingProduct.isPresent()) {
			productRepository.deleteById(id);

		} else {
			throw new InvalidProductIDException("Product with code " + id + " is Not Found.");
		}

	}

}
