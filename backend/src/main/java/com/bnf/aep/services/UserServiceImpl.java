package com.bnf.aep.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bnf.aep.DTO.UserDTO;
import com.bnf.aep.entities.User;
import com.bnf.aep.exception.UserException;
import com.bnf.aep.repositories.IUserRepository;


@Service
public class UserServiceImpl implements IUserService {

	public static final String MESSAGE_ERROR = "Erro interno no servidor, consulte o suporte!!!";
	
	public static final String MESSAGE_ERROR_DOADOR_NOT_FOUND = "Usuario nao encontrado, tente novamente.";

	private static final String MESSAGE_ERRO_CADASTRO = "Usuario já possui cadastro.";
	
	@Autowired
	private IUserRepository usuarioRepository;
	
	private ModelMapper mapper;
	
	@Autowired
	public UserServiceImpl(IUserRepository usuarioRepository) {
		this.mapper = new ModelMapper();
		this.usuarioRepository = usuarioRepository;
	}


	@Override
	public UserDTO deletar(Long id) throws UserException{
		try {
			this.buscaPorId(id);
			this.usuarioRepository.deleteById(id);
			return null;
			
		}catch (UserException m) {
			throw m;
		} catch (Exception e) {
			throw e;
		}
	}


	@Override
	public User buscaPorId(Long id) throws UserException{
		try {
			Optional<User> daodorOptional = this.usuarioRepository.findById(id);
			if (daodorOptional.isPresent()) {
				return this.mapper.map(daodorOptional.get(), User.class);
			}
			throw new UserException(MESSAGE_ERROR_DOADOR_NOT_FOUND, HttpStatus.NOT_FOUND);
		} catch (UserException m) {
			throw m;
		} catch (Exception e) {
			throw new UserException(MESSAGE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public UserDTO atualizarUsuario(UserDTO Usuario) throws UserException{
		try {
			this.atualizarUsuario(Usuario);
		} catch (UserException c) {
			throw c;
		} catch (Exception e) {
			throw e;
		}
		return null;
	}

	@Override
	public void cadastrarUsuario(User usuario) throws UserException{
		try {
			User user = this.mapper.map(usuario, User.class);
			usuarioRepository.save(user);
		}catch (Exception e) {
			throw new UserException(MESSAGE_ERRO_CADASTRO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}