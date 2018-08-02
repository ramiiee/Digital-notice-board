package com.proj.nb.board.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.nb.board.model.Favorite;

@Transactional
public interface FavRepository extends JpaRepository<Favorite,Long>{

	
	List<Favorite> findAllByUsername(String username);
	
	boolean findByUsernameAndImages(String username, String imagename);
	
	void deleteByUsernameAndImages(String username,String imagename);

	
}
