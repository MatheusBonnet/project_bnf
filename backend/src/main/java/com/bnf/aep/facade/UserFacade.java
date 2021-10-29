package com.bnf.aep.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnf.aep.DTO.UserDTO;
import com.bnf.aep.entities.User;
import com.bnf.aep.facade.populators.Populator;
import com.bnf.aep.services.IUserService;

@Service
public class UserFacade {

	@Autowired
	private Populator<UserDTO, User> userReversePopulator;
	
	@Autowired
	private IUserService userService;

	public Populator<UserDTO, User> getUserReversePopulator() {
		return userReversePopulator;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setUserReversePopulator(Populator<UserDTO, User> userReversePopulator) {
		this.userReversePopulator = userReversePopulator;
	}
	
	public User registerUser(UserDTO userDTO) {
		User user = new User();
		getUserReversePopulator().populate(userDTO, user);
		getUserService().cadastrarUsuario(user);
		return user;
	}
}
