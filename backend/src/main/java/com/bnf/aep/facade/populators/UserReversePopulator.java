package com.bnf.aep.facade.populators;

import org.springframework.stereotype.Service;

import com.bnf.aep.DTO.UserDTO;
import com.bnf.aep.entities.User;

@Service
public class UserReversePopulator implements Populator<UserDTO, User>{

	@Override
	public void populate(UserDTO source, User target) {
		source.setNome(target.getNome());
		source.setEmail(target.getEmail());
		source.setCpf(target.getCpf());
		source.setEndereco(target.getEndereco());
		source.setPassword(target.getPassword());
		source.setToken(target.getToken());
	}

}
