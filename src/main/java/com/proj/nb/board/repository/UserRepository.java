package com.proj.nb.board.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proj.nb.board.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
