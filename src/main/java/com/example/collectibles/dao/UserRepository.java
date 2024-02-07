package com.example.collectibles.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.collectibles.beans.User_;

@Repository
public interface UserRepository extends CrudRepository<User_, Long> {
	
	

}
