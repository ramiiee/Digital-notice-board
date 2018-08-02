package com.proj.nb.board.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.nb.board.model.PermanentImages;


@Transactional
public interface PermanentRepository extends JpaRepository<PermanentImages , Long>{
		//Login findByUsername(String username);
		
		PermanentImages findById(Integer id);
	//	PermanentImages findByImname(String imagename);
		//findByImageName ani isthe error vastadi findByImagename...adhe ila isthe crct...'camelCase' lo isthe automatic ga spring own implementation tho manakem kavalo adhistadi 
		PermanentImages findByImagename(String imagename);
		
		List<PermanentImages> findAllByCategory(Integer category);
		
		
		
}
