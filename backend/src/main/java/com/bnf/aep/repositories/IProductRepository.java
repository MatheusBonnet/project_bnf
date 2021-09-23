package com.bnf.aep.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnf.aep.entities.Products;

@Repository
public interface IProductRepository extends JpaRepository<Products, Long>{

	
//	@Query("select m from Produtos m where m.produto = :nome")
//	public List<Products> findByName(@Param("nome")String string);
}
