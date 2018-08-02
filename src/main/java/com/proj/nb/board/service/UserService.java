package com.proj.nb.board.service;

import java.util.List;

import com.proj.nb.board.model.TemporaryAdmin;

public interface UserService {

	
	TemporaryAdmin findById(Long id);
	
	TemporaryAdmin findByName(String name);
	 
    void saveDetails(TemporaryAdmin user);
 
    void updateDetails(TemporaryAdmin user);
 
    void deleteTupleById(Long id);
 
    void deleteAllTuples();
 
    List<TemporaryAdmin> findAllTuples();
 
    boolean isTupleExist(TemporaryAdmin user);
	
}
