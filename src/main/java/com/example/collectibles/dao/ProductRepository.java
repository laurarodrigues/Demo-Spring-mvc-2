package com.example.collectibles.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.collectibles.beans.Product;

@Repository
public interface ProductRepository extends CrudRepository< Product, Integer> {
	
	@Query("select p from Product as p where p.name like %:searchString%")
	public List<Product> searchByName(@Param("searchString") String keyword);
	
	@Query("select p from Product as p where p.id = :id")
	public Product searchById(@Param("id") String keyword);	
	
	@Query("select p from Product as p where p.category_id = :id")
	public List<Product> searchByCategoryId(@Param("id") Integer keyword);	
	
	
	
}
