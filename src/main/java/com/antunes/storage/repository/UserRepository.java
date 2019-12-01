package com.antunes.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.antunes.storage.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
