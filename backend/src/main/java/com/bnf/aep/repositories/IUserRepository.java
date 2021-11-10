package com.bnf.aep.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnf.aep.entities.Users;

@Repository
public interface IUserRepository extends JpaRepository<Users, Long>{

	Users findByEmail(String email);

	public Optional<Users> findByCpf(String cpf);



}
