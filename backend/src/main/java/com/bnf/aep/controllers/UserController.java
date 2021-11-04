package com.bnf.aep.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bnf.aep.DTO.UserDTO;
import com.bnf.aep.entities.User;
import com.bnf.aep.model.Response;
import com.bnf.aep.repositories.IUserRepository;
import com.bnf.aep.services.IUserService;

@RestController
@RequestMapping("/doadores")
public class UserController {

	public static final String UPDATE = "Atualizado com sucesso.";

	public static final String DELETE = "Deletado com sucesso";
	
	@Autowired
	private IUserService userService;
		
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}


    private final IUserRepository repository;
    
    private final PasswordEncoder encoder;

    public UserController(IUserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<User>> listarTodos() {
        return ResponseEntity.ok(repository.findAll());
    }


    @GetMapping("/validarSenha")
    public ResponseEntity<Boolean> validarSenha(@RequestParam String cpf,
                                                @RequestParam String password) {

        Optional<User> optUsuario = repository.findByCpf(cpf);
        if (optUsuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        User usuario = optUsuario.get();
        boolean valid = encoder.matches(password, usuario.getPassword());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }
    
    @PutMapping("/{id}")
	public ResponseEntity<Response<User>> atualizarDoador( @RequestBody UserDTO user){
		Response<User> response = new Response<>();
		response.setData(this.getUserService().atualizarUsuario(user));
		response.setStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
