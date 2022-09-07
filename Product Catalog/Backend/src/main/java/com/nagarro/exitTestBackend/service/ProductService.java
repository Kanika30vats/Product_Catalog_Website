package com.nagarro.exitTestBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.exitTestBackend.model.Product;
import com.nagarro.exitTestBackend.repo.ProductRepo;

/**
 * 
 * @author kanikasharma02
 *
 */
@Service
public class ProductService {

	@Autowired
	private ProductRepo prodRepo;

	public List<Product> fetchProductByName(String name) {
		return prodRepo.findByName(name);
	}

}
