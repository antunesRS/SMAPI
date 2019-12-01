package com.antunes.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.antunes.storage.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
