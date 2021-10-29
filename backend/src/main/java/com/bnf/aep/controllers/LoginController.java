package com.bnf.aep.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnf.aep.DTO.UserDTO;
import com.bnf.aep.entities.DadosLogin;
import com.bnf.aep.entities.User;
import com.bnf.aep.services.UserAuthenticationService;
import com.bnf.aep.services.UserRegistrationService;

/**
 * @author matheus
 *
 */

@RestController
@RequestMapping("/auth")
public class LoginController {
	
	@Autowired
	private UserAuthenticationService userAuthenticationService;
	
	@Autowired
	private UserRegistrationService userRegistrationService;
	
	@Autowired
    LoginController(UserAuthenticationService userAuthenticationService,
    		UserRegistrationService userRegistrationService) {
        this.userAuthenticationService = userAuthenticationService;
        this.userRegistrationService = userRegistrationService;
    }

    @PostMapping("/singin")
    public ResponseEntity<UserDTO> autenticar(@RequestBody DadosLogin dadosLogin, @RequestHeader String Authorization){
        User user = userAuthenticationService.authenticate(dadosLogin, Authorization);
        return new ResponseEntity<UserDTO>(UserDTO.toDTO(user, "Bearer "), HttpStatus.ACCEPTED);
    }
    
    @PostMapping("/singup")
    public ResponseEntity<UserDTO> registrate(@RequestBody User userDTO){
        User user = userRegistrationService.registrate(userDTO);
        return new ResponseEntity<UserDTO>(UserDTO.toDTO(user, "Bearer "), HttpStatus.CREATED);
    }

}
