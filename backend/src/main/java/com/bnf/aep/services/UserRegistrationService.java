package com.bnf.aep.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnf.aep.entities.User;
import com.bnf.aep.repositories.IUserRepository;
/**
 * @author matheus
 *
 */

@Service
public class UserRegistrationService {
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private TokenService tokenService;

	@Autowired
	public UserRegistrationService(IUserRepository userRepository, TokenService tokenService) {
		this.userRepository = userRepository;
		this.tokenService = tokenService;
	}

	public User registrate(User user) {
		user.setToken(tokenService.generateToken(user));
		return userRepository.save(user);
	}

}
