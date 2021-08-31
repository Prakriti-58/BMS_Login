package com.ngn.bms.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ngn.bms.login.service.LeadReportServices;

@RestController
@RequestMapping("leadReport")
@CrossOrigin(origins = {"http://localhost:4200", "http://192.168.124.242","http://103.80.111.102","http://192.168.124.90"})
public class LeadReportController {
	
	@Autowired
	private LeadReportServices leadReportService;	
	
	@GetMapping("/test/{userId}/{queryType}")// for reference
	public  List<ObjectNode> get(@PathVariable int userId,@PathVariable String queryType){
		return leadReportService.test(userId,queryType);
	} 

}
