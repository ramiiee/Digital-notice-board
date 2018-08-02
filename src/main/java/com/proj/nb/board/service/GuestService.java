package com.proj.nb.board.service;

import com.proj.nb.board.model.Guest;
import com.proj.nb.board.model.TemporaryAdmin;


public interface GuestService {

	
	Guest findByName(String name);
	
	void saveDetails(Guest user);
	
	boolean isTupleExist(Guest user);
	
   boolean authpassword(String username,String password);
}
