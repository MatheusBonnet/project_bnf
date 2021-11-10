package com.bnf.aep.facade.populators;

import org.springframework.stereotype.Service;

import com.bnf.aep.DTO.UserDTO;
import com.bnf.aep.entities.Users;

@Service
public class UserPopulator implements Populator<Users, UserDTO>{

	@Override
	public void populate(Users source, UserDTO target) {	
		target.setNome(source.getNome());
		target.setEmail(source.getEmail());
		target.setCpf(source.getCpf());
		target.setEndereco(source.getEndereco());
		target.setPassword(source.getPassword());
	}	
}
