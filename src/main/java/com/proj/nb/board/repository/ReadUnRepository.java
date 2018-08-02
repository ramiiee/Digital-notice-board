package com.proj.nb.board.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.nb.board.model.ReadUn;

@Transactional
public interface ReadUnRepository extends JpaRepository<ReadUn,Long>{

	
	ReadUn findByUsernameAndImagename(String username,String imagename);
	List<ReadUn> findAllByUsername(String username);
	void deleteAllByImagename(String imagename);
}
