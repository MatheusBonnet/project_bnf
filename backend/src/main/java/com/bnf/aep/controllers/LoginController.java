package com.bnf.aep.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.bnf.aep.DTO.UserAuthenticationDTO;
import com.bnf.aep.entities.DadosLogin;
import com.bnf.aep.entities.User;
import com.bnf.aep.services.UserAuthenticationService;

/**
 * @author matheus
 *
 */

@RestController
public class LoginController {
	
	@Autowired
	private UserAuthenticationService userAuthenticationService;

	@Autowired
    LoginController(UserAuthenticationService userAuthenticationService) {
        this.userAuthenticationService = userAuthenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserAuthenticationDTO> autenticar(@RequestBody DadosLogin dadosLogin, @RequestHeader String Authorization){
        User user = userAuthenticationService.authenticate(dadosLogin, Authorization);
        return new ResponseEntity<UserAuthenticationDTO>(UserAuthenticationDTO.toDTO(user, "Bearer "), HttpStatus.ACCEPTED);
    }


}
