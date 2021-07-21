package com.ngn.bms.login.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "menus")
public class Menus {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@Column( name = "menu_name" )
		private String menuName;
		@Column( name = "status")
		private String status;
		private String route;
		private String icon;
		
		@OneToMany()
		@JoinColumn(name = "menu_id", referencedColumnName = "id")
		private List<SubMenus> subMenus;
		
		public Menus() {
			super();
		}

		public Menus(int id, String menuName, String status, String route, String icon, List<SubMenus> subMenus) {
			super();
			this.id = id;
			this.menuName = menuName;
			this.status = status;
			this.route = route;
			this.icon = icon;
			this.subMenus = subMenus;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getMenuName() {
			return menuName;
		}

		public void setMenuName(String menuName) {
			this.menuName = menuName;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getRoute() {
			return route;
		}

		public void setRoute(String route) {
			this.route = route;
		}

		public String getIcon() {
			return icon;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}

		public List<SubMenus> getSubMenus() {
			return subMenus;
		}

		public void setSubMenus(List<SubMenus> subMenus) {
			this.subMenus = subMenus;
		}
		
		

				
}
