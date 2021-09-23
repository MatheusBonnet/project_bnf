package com.bnf.aep.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bnf.aep.DTO.UserAuthenticationDTO;
import com.bnf.aep.DTO.UserRegistrationDTO;
import com.bnf.aep.entities.User;
import com.bnf.aep.services.UserRegistrationService;
import com.bnf.facade.populators.UserPopulator;
import com.bnf.facade.populators.UserReversePopulator;

/**
 * @author matheus
 *
 */

@RestController
public class UserRegistrationController {
	
	private UserRegistrationService userRegistrationService;
	
	

    @Autowired
    public UserRegistrationController(UserRegistrationService userRegistrationService){
        this.userRegistrationService = userRegistrationService;
    }

    public UserRegistrationController(){

    }

    @PostMapping("/user")
    public ResponseEntity<UserAuthenticationDTO> registrate(@RequestBody UserRegistrationDTO userRegistrationDTO, 
    		UserReversePopulator reverseuserPopulator){
        User user = userRegistrationService.registrate(reverseuserPopulator);
        return  new ResponseEntity<UserAuthenticationDTO>(UserAuthenticationDTO.toDTO(user, "Bearer "), HttpStatus.CREATED);
    }

}
