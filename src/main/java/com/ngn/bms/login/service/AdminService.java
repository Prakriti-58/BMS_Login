package com.ngn.bms.login.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TupleElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ngn.bms.login.model.Menus;
import com.ngn.bms.login.repository.MenuRepository;

@Service
public class AdminService {

	@Autowired
	private MenuRepository menuRepository; 
	
	public List<Menus> getUserPrivilages(Integer userId) {
		return menuRepository.findByUserId(userId);
	}

	@PersistenceContext
	  private EntityManager entityManager;

	  @SuppressWarnings("unchecked")
	  public List<ObjectNode> test(int user_id){
	    String queryStr = "SELECT * FROM menus a LEFT JOIN sub_menus b ON b.menu_id=a.id LEFT JOIN user_privilege c ON c.sub_menu_id=b.id WHERE c.user_id=?1";
	    try {
	      Query query = entityManager.createNativeQuery(queryStr, Tuple.class);
	      query.setParameter(1, user_id);
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
