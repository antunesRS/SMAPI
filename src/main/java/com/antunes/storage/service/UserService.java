package com.antunes.storage.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import com.antunes.storage.domain.User;
import com.antunes.storage.repository.UserRepository;

public class UserService {

	@Autowired
	private UserRepository repo;
	
	public void save(User obj) {
		repo.save(obj);
	}
	public void saveAll(List<User> objList) {
		repo.saveAll(objList);
	}
	
	public User find(Integer id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Not found", null));
	}
	
	public List<User> getList(){
		 return repo.findAll();
	}
	
	public void update(User obj) throws ObjectNotFoundException {
		
		if(repo.existsById(obj.getId())) {
			User oldObj = repo.getOne(obj.getId());
			repo.delete(oldObj);
			repo.save(obj);
		}
		else
			throw new ObjectNotFoundException("Not found", null);
	}
	
	public void delete(Integer id) throws ObjectNotFoundException {
		if(repo.existsById(id)) {
			User obj = repo.getOne(id);
			repo.delete(obj);
		}
		else
			throw new ObjectNotFoundException("Not found", null);
	}
}
