package com.proj.nb.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.nb.board.model.AnalyticsViews;

public interface AnalyticsViewsRepository extends JpaRepository<AnalyticsViews,Long>{

	
	
		List<AnalyticsViews> findAllByUsername(String username);
		
		AnalyticsViews findByUsernameAndImagename(String Username,String imagename);
		
		AnalyticsViews findByImagename(String imagename);
}
