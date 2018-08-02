package com.proj.nb.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.nb.board.model.AnalyticsRegistered;

public interface AnalyticsRegisteredRepository extends JpaRepository<AnalyticsRegistered,Long>{

	
	List<AnalyticsRegistered> findByImagename(String imagename);
	
	
}
