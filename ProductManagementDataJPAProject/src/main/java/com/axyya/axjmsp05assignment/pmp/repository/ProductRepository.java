package com.axyya.axjmsp05assignment.pmp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axyya.axjmsp05assignment.pmp.dto.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
