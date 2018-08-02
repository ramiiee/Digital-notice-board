package com.proj.nb.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.nb.board.model.TemporaryAdmin;
import com.proj.nb.board.repository.TemporaryRepoistory;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private TemporaryRepoistory tr;
	
	public TemporaryAdmin findById(Long id) {
		// TODO Auto-generated method stub
	//	return null;
		
		return  tr.findOne(id);
		
	}

	public TemporaryAdmin findByName(String name) {
		// TODO Auto-generated method stub
	//	return null;
	
			return tr.findByName(name);
	
	
	}

	public void saveDetails(TemporaryAdmin user) {
		// TODO Auto-generated method stub
		
		tr.save(user);
		
	}

	public void updateDetails(TemporaryAdmin user) {
		// TODO Auto-generated method stub
		
		saveDetails(user);
		
	}

	public void deleteTupleById(Long id) {
		// TODO Auto-generated method stub
		
		tr.delete(id);
		
	}
	
	public void deleteTupleByName(String name){
		
		tr.deleteByName(name);//crazy spring nik ye mhtod kavalo aaa method ni cameCase lo rasi dengthe adhe chuskutnadi CRUD operations motham
	}

	public void deleteAllTuples() {
		// TODO Auto-generated method stub
		tr.deleteAll();
	}

	public List<TemporaryAdmin> findAllTuples() {
		// TODO Auto-generated method stub
		
		return tr.findAll();
	//	return null;
	}

	public boolean isTupleExist(TemporaryAdmin user) {
		// TODO Auto-generated method stub
	//	return false;
		
	return findByName(user.getName())!=null;
		
		
	}

	
}
