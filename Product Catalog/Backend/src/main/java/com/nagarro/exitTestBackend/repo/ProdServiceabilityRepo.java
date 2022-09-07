package com.nagarro.exitTestBackend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nagarro.exitTestBackend.model.ProdServiceability;

/**
 * 
 * @author kanikasharma02
 *
 */
public interface ProdServiceabilityRepo extends JpaRepository<ProdServiceability, Integer> {

	@Query(value = "FROM ProdServiceability where pId=?1 and pincode=?2")
	public List<ProdServiceability> getTime(int pid, long pincode);

}
