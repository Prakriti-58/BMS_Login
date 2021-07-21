package com.ngn.bms.login.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ngn.bms.login.model.UserPrivilage;

public interface UserPrivilagesRepo extends JpaRepository<UserPrivilage, Integer> {

	@Query(value = "SELECT * FROM user_privilege a WHERE a.`user_id`=?1 AND a.`sub_menu_id`=14",nativeQuery = true)
	UserPrivilage findAllByUserId(int userId);

}
