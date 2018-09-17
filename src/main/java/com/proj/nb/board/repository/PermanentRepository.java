package com.proj.nb.board.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.nb.board.model.PermanentImages;


@Transactional
public interface PermanentRepository extends JpaRepository<PermanentImages , Long>{
		
		
		PermanentImages findById(Integer id);
			
		PermanentImages findByImagename(String imagename);
		
		List<PermanentImages> findAllByCategory(Integer category);
		
		
		
}
