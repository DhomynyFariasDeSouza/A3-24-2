package com.a3.api.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a3.api.Entity.Item;
import com.a3.api.Repository.itemRepository;

@Service
public class ItemService {
	
	@Autowired
	private itemRepository repository;
	
	public List<Item> findAll(){
		return repository.findAll();
	}
	
	public Item findById(String id) {
		Optional<Item> obj = repository.findById(id);
		return obj.get();
	}
    
	public Item insert(Item obj) {
		return repository.save(obj);
	}
	
	public void delete(String id) {
		repository.deleteById(id);
	}
	
	public Item update(String id, Item obj) {
		Item entity = repository.getReferenceById(id);
		updateData(entity,obj);
		return repository.save(entity);
	}

	private void updateData(Item entity, Item obj) {
		entity.setDescricao(obj.getDescricao());
		entity.setNome(obj.getNome());
		entity.setValor(obj.getValor());
		
	}
}
