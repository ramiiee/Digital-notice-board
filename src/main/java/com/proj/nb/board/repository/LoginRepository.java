package com.proj.nb.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.nb.board.model.Login;



public interface LoginRepository extends JpaRepository<Login, Long>{
	Login findByUsername(String username);
}
