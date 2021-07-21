package com.ngn.bms.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngn.bms.login.model.SubMenus;

public interface SubMenuRepo extends JpaRepository<SubMenus, Integer> {

}
