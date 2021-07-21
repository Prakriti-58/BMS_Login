package com.ngn.bms.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngn.bms.login.model.CompetitorEntity;

@Repository
public interface CompetitorRepo extends JpaRepository<CompetitorEntity, Integer>{

}
