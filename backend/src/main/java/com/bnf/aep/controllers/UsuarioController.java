package com.bnf.aep.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
	
	@GetMapping("/home")
    public String entrar() {
        return "ola tudo bem ?";
    }
	
	@GetMapping("/") 
    public String inicio() {
        return "inicio";
    }

}
