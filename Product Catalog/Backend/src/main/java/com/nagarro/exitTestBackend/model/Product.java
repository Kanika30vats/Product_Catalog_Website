/**
 * 
 */
package com.nagarro.exitTestBackend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author kanikasharma02
 *
 */
@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pId;

	private String name;

	private String code;

	private String brand;

	private String image;

	private String descripiton;

	private double price;

	@OneToMany(targetEntity = ProdServiceability.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "prodId", referencedColumnName = "pId")
	private List<Integer> pincode;

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDesc() {
		return descripiton;
	}

	public void setDesc(String desc) {
		this.descripiton = desc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Integer> getPincode() {
		return pincode;
	}

	public void setPincode(List<Integer> pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Product [pId=" + pId + ", name=" + name + ", code=" + code + ", brand=" + brand + ", image=" + image
				+ ", description=" + descripiton + ", price=" + price + ", pincode=" + pincode + "]";
	}

}
