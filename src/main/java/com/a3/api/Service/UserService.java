package com.a3.api.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.a3.api.Entity.User;
import com.a3.api.Repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
    
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity,obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setAddress(obj.getAddress());
		entity.setAvatar(obj.getAvatar());
		entity.setEmail(obj.getEmail());
		entity.setName(obj.getName());
		entity.setOpen(obj.isOpen());
		entity.setCover(obj.getCover());
		
	}
}
