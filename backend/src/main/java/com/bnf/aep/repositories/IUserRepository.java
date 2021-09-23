package com.bnf.aep.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnf.aep.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{

	User findById(String cpf);

}
