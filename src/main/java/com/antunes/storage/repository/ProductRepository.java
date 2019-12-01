package com.antunes.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.antunes.storage.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>  {
	
}
