package com.ngn.bms.login.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sub_menus")
public class SubMenus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "menu_id")
	private int menuId;
	@Column(name = "sub_menu_name")
	private String subMenuName;
	private String route_link;
	@Column(name = "status")
	private String status;

	
	@OneToOne()
	@JoinColumn(name = "sub_menu_id", referencedColumnName = "id")
	private UserPrivilage userPrivilage;
	
	public SubMenus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubMenus(int id, int menuId, String subMenuName, String route_link, String status,
			UserPrivilage userPrivilage) {
		super();
		this.id = id;
		this.menuId = menuId;
		this.subMenuName = subMenuName;
		this.route_link = route_link;
		this.status = status;
		this.userPrivilage = userPrivilage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getSubMenuName() {
		return subMenuName;
	}

	public void setSubMenuName(String subMenuName) {
		this.subMenuName = subMenuName;
	}

	public String getRoute_link() {
		return route_link;
	}

	public void setRoute_link(String route_link) {
		this.route_link = route_link;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserPrivilage getUserPrivilage() {
		return userPrivilage;
	}

	public void setUserPrivilage(UserPrivilage userPrivilage) {
		this.userPrivilage = userPrivilage;
	}

	

	
}
