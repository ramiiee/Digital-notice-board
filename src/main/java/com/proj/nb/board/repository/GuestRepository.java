package com.proj.nb.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.nb.board.model.Guest;

public interface GuestRepository extends JpaRepository<Guest,Long> {

	Guest findByUsername(String username);
	
		
}
