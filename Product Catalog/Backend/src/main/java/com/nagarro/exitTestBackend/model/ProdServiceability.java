/**
 * 
 */
package com.nagarro.exitTestBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author kanikasharma02
 *
 */
@Entity
@Table(name = "ProductService")
public class ProdServiceability {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int pId;

	private long pincode;

	private int expectedDeliveryTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public int getExpectedDeliveryTime() {
		return expectedDeliveryTime;
	}

	public void setExpectedDeliveryTime(int expectedDeliveryTime) {
		this.expectedDeliveryTime = expectedDeliveryTime;
	}

	@Override
	public String toString() {
		return "ProdServiceability [id=" + id + ", pId=" + pId + ", pincode=" + pincode + ", expectedDeliveryTime="
				+ expectedDeliveryTime + "]";
	}

}
