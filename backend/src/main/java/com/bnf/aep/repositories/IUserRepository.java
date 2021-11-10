package com.bnf.aep.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnf.aep.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);

	public Optional<User> findByCpf(String cpf);



}
