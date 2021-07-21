package com.ngn.bms.login.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_categories")
public class ProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(name = "oem_id")
	private int oemId;
	private String description;
	private String status;
	
	public ProductCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProductCategory(int id, String name, int oemId, String description, String status) {
		super();
		this.id = id;
		this.name = name;
		this.oemId = oemId;
		this.description = description;
		this.status = status;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOemId() {
		return oemId;
	}

	public void setOemId(int oemId) {
		this.oemId = oemId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
