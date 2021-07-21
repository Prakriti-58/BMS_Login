package com.ngn.bms.login.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ngn.bms.login.model.CompetitorEntity;
import com.ngn.bms.login.model.Menus;
import com.ngn.bms.login.model.Organization;
import com.ngn.bms.login.model.OrganizationType;
import com.ngn.bms.login.model.Source;
import com.ngn.bms.login.model.SubMenus;
import com.ngn.bms.login.model.TenderType;
import com.ngn.bms.login.model.UserPrivilage;
import com.ngn.bms.login.repository.CompetitorRepo;
import com.ngn.bms.login.repository.MenuRepository;
import com.ngn.bms.login.repository.OrganizationRepo;
import com.ngn.bms.login.repository.OrganizationTypeRepo;
import com.ngn.bms.login.repository.SourceRepo;
import com.ngn.bms.login.repository.SubMenuRepo;
import com.ngn.bms.login.repository.TenderTypeRepo;
import com.ngn.bms.login.repository.UserPrivilagesRepo;
import com.ngn.bms.login.service.AdminService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://192.168.124.242","http://103.80.111.102"})
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private SourceRepo sourceRepo;
	
	@Autowired
	private SubMenuRepo subMenuRepo;
	
	@Autowired
	private OrganizationTypeRepo organizationTypeRepo;
	
	@Autowired
	private OrganizationRepo organizationRepo;
	
	@Autowired
	private TenderTypeRepo tenderTypeRepo;
	
	@Autowired
	private UserPrivilagesRepo userPrivilagesRepo;
	
	@Autowired
	private CompetitorRepo competitorRepo;
	
	
	@GetMapping("/user-privilage/{userId}")
	public  List<Menus> getUserPrivilages(@PathVariable int userId){
		return adminService.getUserPrivilages(userId);
	} 
	
	@Autowired
	private MenuRepository menuRepository; 
	
	public List<Menus> getUserPrivilages(Integer userId) {
		return menuRepository.findByUserId(userId);
	}
	
	@GetMapping("/menusss/{userId}")
	public Menus menus(@PathVariable Integer userId) {
		return menuRepository.findById(userId).orElse(null);
	}

	
	@GetMapping("subMenus/{id}")
	public SubMenus getSubMenus(@PathVariable int id) {
		return subMenuRepo.findById(id).orElse(null);
	}
	
	@GetMapping("test/{userId}")// for reference
	public  List<ObjectNode> get(@PathVariable int userId){
		return adminService.test(userId);
	} 
	
	@GetMapping("source")
	public List<Source> getSourceList(){
		return sourceRepo.findAll();
	}
	
	@GetMapping("tenderType")
	public List<TenderType> geTenderTypes(){
		return tenderTypeRepo.findAll();
	}
	
	
	@GetMapping("organizationType")
	public List<OrganizationType> getOrganizationTypesList(){
		return organizationTypeRepo.findAll();
	}
	
	@GetMapping("organization/{orgTypeId}")
	public List<Organization> getOrganizations(@PathVariable Integer orgTypeId){
		return organizationRepo.findByOrganizationTypeId(orgTypeId);
	}
	
	@GetMapping("organizationList")
	public List<Organization> getOrganizationsList(){
		return organizationRepo.findAll();
	}
	
	//TSSD USER PRIVILEDGE
	
	@GetMapping("tssd/user-privilege/{userId}")
	public UserPrivilage getTssdUserPrivilage(@PathVariable Integer userId){
		return userPrivilagesRepo.findAllByUserId(userId);
	}
	
	@GetMapping("admin/competitor")
	public List<CompetitorEntity> getAllCompetitor(){ 
		return competitorRepo.findAll(); 
	}
	
}
