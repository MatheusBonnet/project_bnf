package com.bnf.aep.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnf.aep.DTO.UserDTO;
import com.bnf.aep.entities.User;
import com.bnf.aep.exception.InvalidSingupException;
import com.bnf.aep.facade.UserFacade;
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
	private UserFacade userFacade;

	@Autowired
	public UserRegistrationService(IUserRepository userRepository, TokenService tokenService, UserFacade userFacade) {
		this.userRepository = userRepository;
		this.tokenService = tokenService;
		this.userFacade = userFacade;
	}
	
	public IUserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public TokenService getTokenService() {
		return tokenService;
	}

	public void setTokenService(TokenService tokenService) {
		this.tokenService = tokenService;
	}

	public UserFacade getUserFacade() {
		return userFacade;
	}

	public void setUserFacade(UserFacade userFacade) {
		this.userFacade = userFacade;
	}

	public User registrate(User user){
		if(user != null) {		
			user.setToken(getTokenService().generateToken(user));
			return getUserRepository().save(user);
		}
		throw new InvalidSingupException();
	}

}
