package com.bnf.aep.facade.populators;

import org.springframework.stereotype.Service;

import com.bnf.aep.DTO.UserDTO;
import com.bnf.aep.entities.User;

@Service
public class UserPopulator implements Populator<User, UserDTO>{

	@Override
	public void populate(User source, UserDTO target) {	
		target.setNome(source.getNome());
		target.setEmail(source.getEmail());
		target.setCpf(source.getCpf());
		target.setEndereco(source.getEndereco());
		target.setPassword(source.getPassword());
	}	
}
