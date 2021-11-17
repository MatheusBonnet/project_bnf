package com.bnf.aep.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnf.aep.DTO.UserDTO;
import com.bnf.aep.entities.Users;
import com.bnf.aep.facade.populators.Populator;
import com.bnf.aep.repositories.IUserRepository;
import com.bnf.aep.services.IUserService;

@Service
public class UserFacade {

	@Autowired
	private Populator<UserDTO, Users> userReversePopulator;
	
	@Autowired
	private IUserService userService;
	
	
	@Autowired
	private IUserRepository repository;

	public Populator<UserDTO, Users> getUserReversePopulator() {
		return userReversePopulator;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setUserReversePopulator(Populator<UserDTO, Users> userReversePopulator) {
		this.userReversePopulator = userReversePopulator;
	}
	
	public IUserRepository getRepository() {
		return repository;
	}

	public void setRepository(IUserRepository repository) {
		this.repository = repository;
	}
	
	public Users registerUser(UserDTO userDTO) {
		Users user = new Users();
		getUserReversePopulator().populate(userDTO, user);
		getRepository().save(user);
		return user;
	}
	
	public Users updateDataUser(Users user) {
		getRepository().save(user);
		return user;
	}

	
}
