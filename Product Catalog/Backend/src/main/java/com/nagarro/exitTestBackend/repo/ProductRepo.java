/**
 * 
 */
package com.nagarro.exitTestBackend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nagarro.exitTestBackend.model.Product;

/**
 * 
 * @author kanikasharma02
 *
 */
public interface ProductRepo extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

	public List<Product> findByName(String name);
	
	@Query(value = "FROM Product order by price asc")
	public List<Product> findAllByPriceAsc();
	
	@Query(value = "FROM Product order by price desc")
	public List<Product> findAllByPriceDesc();

	public List<Product> findByBrand(String brand);

	@Query(value = "FROM Product where name=?1 or brand=?2 or code=?3")
	public List<Product> getPro(String name, String brand, String code);
	
	@Query(value = "FROM Product where name=?1 or brand=?2 or code=?3 order by price asc ")
	public List<Product> findByPriceAsc(String name,String brand, String code);

	@Query(value = "FROM Product where name=?1 or brand=?2 or code=?3 order by price desc ")
	public List<Product> findByPriceDesc(String name, String brand, String code);

}
