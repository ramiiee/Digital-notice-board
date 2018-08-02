package com.proj.nb.board.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.nb.board.model.TemporaryAdmin;

@Transactional
public interface TemporaryRepoistory extends JpaRepository<TemporaryAdmin , Long>{
	
	TemporaryAdmin findById(Long id);
	
	TemporaryAdmin findByName(String name);
//	TemporaryAdmin fingByImname(String temporaryimagename);

//	void delete(String imagename);
	
	
//chala chaala jagrathga spellings rayali ledha darunamaina errors vatayi...nenu delte anir asa delete badhulu motham thappani vachesindhi madda -_-
	void deleteByName(String name);

	void deleteAllByName(String name);
}
