package com.bnf.aep.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnf.aep.entities.DadosLogin;
import com.bnf.aep.entities.User;
import com.bnf.aep.exception.ExpiredTokenException;
import com.bnf.aep.exception.InvalidLoginException;
import com.bnf.aep.exception.InvalidTokenException;
import com.bnf.aep.repositories.IUserRepository;

import io.jsonwebtoken.Claims;
/**
 * @author matheus
 *
 */
@Service
public class UserAuthenticationService {
	
	
	@Autowired
	private IUserRepository usuarioRepo;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	public UserAuthenticationService(IUserRepository usuarioRepo, TokenService tokenService ) {
		this.usuarioRepo = usuarioRepo;
		this.tokenService = tokenService;
	}
	
	public User authenticate(DadosLogin dados, String token){
		User user = usuarioRepo.findByEmail(dados.getEmail());
        if(dados.getPassword().equals(user.getPassword()) && !token.isEmpty() && validate(token)) {
            String newToken  = tokenService.generateToken(user);
            user.setToken(newToken);
            return user;
        }
        else {
            throw new InvalidLoginException();
        }
    }

    private boolean validate(String token) {
        try {
            String tokenTratado = token.replace("Bearer ", "");
            Claims claims = tokenService.decodeToken(tokenTratado);
            //Verifica se o token está expirado
            if (claims.getExpiration().before(new Date(System.currentTimeMillis()))) throw new ExpiredTokenException();
            return true;
        } catch (ExpiredTokenException et){
            et.printStackTrace();
            throw et;
        } catch (Exception e) {
            e.printStackTrace();
            throw new InvalidTokenException();
        }

    }

}
