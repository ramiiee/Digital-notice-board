package com.proj.nb.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.nb.board.model.Guest;
import com.proj.nb.board.repository.GuestRepository;

@Service
public class GuestServiceImpl implements GuestService {

	@Autowired
	GuestRepository gr;
	
	
	public boolean isTupleExist(Guest user) {
		// TODO Auto-generated method stub
	
		return findByName(user.getUsername())!=null;
		
		
	}

	public void saveDetails(Guest user) {
		// TODO Auto-generated method stub
		
		
		gr.save(user);
		
	}

	public Guest findByName(String name) {
		// TODO Auto-generated method stub
		return gr.findByUsername(name);
		
		
	}

	public boolean authpassword(String username, String password) {
		// TODO Auto-generated method stub
		if(gr.findByUsername(username).getPassword().equals(password)){
			
			return true;
		}
		
		
		return false;
	}

}
