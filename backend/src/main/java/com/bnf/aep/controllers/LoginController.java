package com.bnf.aep.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnf.aep.entities.User;
import com.bnf.aep.repositories.IUserRepository;
import com.bnf.aep.services.UserServiceImpl;

/**
 * @author matheus
 *
 */

@RestController
@RequestMapping("/auth")
public class LoginController {
	
	@Autowired
	private UserServiceImpl service;
	
	@Autowired
	private IUserRepository repository;
	
	@Autowired
	private final PasswordEncoder encoder = null;

    
    @PostMapping("/singup")
    public ResponseEntity<User> salvar(@RequestBody User usuario) {
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        return ResponseEntity.ok(repository.save(usuario));
    }
    
    

}
