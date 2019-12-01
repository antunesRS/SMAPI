package com.antunes.storage.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.antunes.storage.domain.Category;
import com.antunes.storage.dto.CategoryDTO;
import com.antunes.storage.repository.CategoryRepository;

@Component("categoryService")
public class CategoryService {
	
	@Autowired
	private CategoryRepository repo;
	
	public void save(Category obj) {
		repo.save(obj);
	}
	public void saveAll(List<Category> objList) {
		repo.saveAll(objList);
	}
	
	public Category find(Integer id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Not found", null));
	}
	
	public List<Category> getList(){
		 return repo.findAll();
	}
	
	public void update(Category obj) throws ObjectNotFoundException {
		
		if(repo.existsById(obj.getId())) {
			Category oldObj = repo.getOne(obj.getId());
			repo.delete(oldObj);
			repo.save(obj);
		}
		else
			throw new ObjectNotFoundException("Not found", null);
	}
	
	public void delete(Integer id) throws ObjectNotFoundException {
		if(repo.existsById(id)) {
			Category obj = repo.getOne(id);
			repo.delete(obj);
		}
		else
			throw new ObjectNotFoundException("Not found", null);
	}
	
	public Category fromDTO(CategoryDTO dto) {
		return new Category(null, dto.getName());
	}
	
	public Page<Category> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
