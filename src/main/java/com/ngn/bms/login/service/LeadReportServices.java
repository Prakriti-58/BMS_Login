package com.ngn.bms.login.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TupleElement;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
@Service
public class LeadReportServices {
	
	@PersistenceContext
	  private EntityManager entityManager;

	  @SuppressWarnings("unchecked")
	  public List<ObjectNode> test(int userId,String queryType){
	    String queryStr = "";
	    Query query = entityManager.createNativeQuery(queryStr, Tuple.class);
	    try {
	    	
	    if(queryType == "CEOBidRegister") {
	    	queryStr = "SELECT z.`reference_no` AS id FROM `tenders` z WHERE z.`status`='Y' OR z.`status`='B'";
	    	//Query query = entityManager.createNativeQuery(queryStr, Tuple.class);
	    
	    }else if(queryType == "CEObidsubmitted") {
	    	queryStr = "";
	    	queryStr = "SELECT z.`reference_no`  FROM `tenders` z WHERE z.`status`='Y' OR z.`status`='?1'";
	    	query.setParameter(1, userId);
	    	//query.setParameter(2, user_id);
	    }	
	    else if(queryType == "CEObidclossed") {
	    	queryStr = "";
	    	queryStr = "SELECT z.`reference_no` FROM `tenders` z WHERE z.`status`='Y' OR z.`status`='?1'";
	    	query.setParameter(1, userId);
	    	//query.setParameter(2, user_id);
	    }	
	    else if(queryType == "WinRate") {
	    	queryStr = "";
	    	queryStr = "SELECT z.`reference_no` AS id FROM `tenders` z WHERE z.`status`='Y' OR z.`status`='?1'";
	    	query.setParameter(1, userId);
	    	//query.setParameter(2, user_id);
	    }	
	    else if(queryType == "LossRate") {
	    	queryStr = "";
	    	queryStr = "SELECT z.`reference_no` AS id FROM `tenders` z WHERE z.`status`='Y' OR z.`status`='?1'";
	    	query.setParameter(1, userId);
	    	//query.setParameter(2, user_id);
	    }	
	    else if(queryType == "Win Percentage") {
	    	queryStr = "";
	    	queryStr = "SELECT z.`reference_no` AS id FROM `tenders` z WHERE z.`status`='Y' OR z.`status`='?1'";
	    	query.setParameter(1, userId);
	    	//query.setParameter(2, user_id);
	    }	
	    else if(queryType == "Loss Percentage") {
	    	queryStr = "";
	    	queryStr = "SELECT z.`reference_no` AS id FROM `tenders` z WHERE z.`status`='Y' OR z.`status`='?1'";
	    	query.setParameter(1, userId);
	    	//query.setParameter(2, user_id);
	    }	
	      List<Tuple> results = query.getResultList();
	      List<ObjectNode> json = _toJson(results);
	      return json;
	    } catch(Exception e) {
	      e.printStackTrace();
	      
	    }

	    return null;
	  }

	  private List<ObjectNode> _toJson(List<Tuple> results) {
	    List<ObjectNode> json = new ArrayList<ObjectNode>();
	    ObjectMapper mapper = new ObjectMapper();
	    for (Tuple t : results) {
	      List<TupleElement<?>> cols = t.getElements();
	      ObjectNode one = mapper.createObjectNode();
	      for (@SuppressWarnings("rawtypes") TupleElement col : cols) {
	        one.put(col.getAlias(), t.get(col.getAlias()).toString());
	      }
	      json.add(one);
	    }

	    return json;
	  }

}
