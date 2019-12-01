package com.antunes.storage.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.antunes.storage.domain.Product;
import com.antunes.storage.dto.ProductDTO;
import com.antunes.storage.repository.ProductRepository;

@Component("productService")
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	public void save(Product obj) {
		repo.save(obj);
	}
	public void saveAll(List<Product> objList) {
		repo.saveAll(objList);
	}
	
	public Product find(Integer id) {
		Optional<Product> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Not found", null));
	}
	
	public List<Product> getList(){
		 return repo.findAll();
	}
	
	public void update(Product obj) throws ObjectNotFoundException {
		
		if(repo.existsById(obj.getId())) {
			Product oldObj = repo.getOne(obj.getId());
			repo.delete(oldObj);
			repo.save(obj);
		}
		else
			throw new ObjectNotFoundException("Not found", null);
	}
	
	public void delete(Integer id) throws ObjectNotFoundException {
		if(repo.existsById(id)) {
			Product obj = repo.getOne(id);
			repo.delete(obj);
		}
		else
			throw new ObjectNotFoundException("Not found", null);
	}
	
	public Product fromDTO(ProductDTO dto) {
		return new Product(null, dto.getName(), dto.getPrice(), dto.getDescription(), dto.getAmount(), dto.getCategory(), dto.getCategoryId());
	}
	
	public Page<Product> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
