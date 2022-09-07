package com.nagarro.exitTestBackend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.exitTestBackend.model.ProdServiceability;
import com.nagarro.exitTestBackend.model.Product;
import com.nagarro.exitTestBackend.repo.ProdServiceabilityRepo;
import com.nagarro.exitTestBackend.repo.ProductRepo;
import com.nagarro.exitTestBackend.service.ProductService;

/**
 * 
 * @author kanikasharma02
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	ProdServiceabilityRepo prodServiceability;

	@Autowired
	ProductRepo productRepo;

	@GetMapping("/allProduct")
	public List<Product> getProductNyName() {
		return productRepo.findAll();
	}

	
	@GetMapping("/{pId}")
	public double getPrice(@PathVariable("pId") int pId) {
		Product product = productRepo.getById(pId);
		return product.getPrice();

	}

	@GetMapping("/desc/{pId}")
	public String getDescription(@PathVariable("pId") int pId) {
		Product product = productRepo.getById(pId);
		return product.getDesc();

	}

	@GetMapping("/singleProduct/{pId}")
	public Optional<Product> getSingleProduct(@PathVariable("pId") int pId) {
		return productRepo.findById(pId);
	}
	
	@GetMapping("/searchByName/{name}")
	public List<Product> getProductByName(@PathVariable("name") String name) {

		return productRepo.findByName(name);
	}

	@GetMapping("/searchByName/{brand}")
	public List<Product> getProductByBrand(@PathVariable("brand") String brand) {

		return productRepo.findByBrand(brand);
	}

	@GetMapping("/searchByNameBrandCode")
	public List<Product> getProducts(@RequestParam("name") String name, @RequestParam("brand") String brand,
			@RequestParam("code") String code) {
		return productRepo.getPro(name, brand, code);
	}


	@GetMapping("/searchPincode")
	public List<ProdServiceability> getDeliveryTime(@RequestParam("pid") int pid,
			@RequestParam("pincode") long pincode) {
		System.out.println("hello");
		return prodServiceability.getTime(pid, pincode);

	}
	
	@GetMapping(value = "/sortAllByPriceAsc", headers = "Accept=application/json")
	public List<Product> sortAllByPriceAsc() {
		return productRepo.findAllByPriceAsc();

	}
	
	@GetMapping(value = "/sortAllByPriceDesc", headers = "Accept=application/json")
	public List<Product> sortAllByPriceDesc() {
		return productRepo.findAllByPriceDesc();

	}

	@GetMapping(value = "/sortbyPriceAsc", headers = "Accept=application/json")
	public List<Product> sortByPriceAsc(@RequestParam("name") String name, @RequestParam("brand") String brand,
			@RequestParam("code") String code) {
		return productRepo.findByPriceAsc(name, brand, code);

	}

	@GetMapping(value = "/sortbyPriceDesc", headers = "Accept=application/json")
	public List<Product> sortByPriceDesc(@RequestParam("name") String name, @RequestParam("brand") String brand,
			@RequestParam("code") String code) {
		return productRepo.findByPriceDesc(name, brand, code);

	}

}
