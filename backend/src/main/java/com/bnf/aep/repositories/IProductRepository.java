package com.bnf.aep.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bnf.aep.entities.Products;

@Repository
public interface IProductRepository extends JpaRepository<Products, Long>{

	
	@Query("SELECT m FROM Products m WHERE m.produto = :nome")
	public List<Products> findByName(@Param("nome")String string);
}
