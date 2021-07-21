package com.ngn.bms.login.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "user_privilege")
public class UserPrivilage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "user_id")
	private int userId;
	@Column(name = "sub_menu_id")
	private int subMenuId;
	private String tssdAddService;
	private String tssdMaintenance;
	private String add;
	private String edit;
	private String delete;
	private String disable;
	
	public UserPrivilage() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSubMenuId() {
		return subMenuId;
	}

	public void setSubMenuId(int subMenuId) {
		this.subMenuId = subMenuId;
	}

	public String getTssdAddService() {
		return tssdAddService;
	}

	public void setTssdAddService(String tssdAddService) {
		this.tssdAddService = tssdAddService;
	}

	public String getTssdMaintenance() {
		return tssdMaintenance;
	}

	public void setTssdMaintenance(String tssdMaintenance) {
		this.tssdMaintenance = tssdMaintenance;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getEdit() {
		return edit;
	}

	public void setEdit(String edit) {
		this.edit = edit;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public String getDisable() {
		return disable;
	}

	public void setDisable(String disable) {
		this.disable = disable;
	}

	
	
}
