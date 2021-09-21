package com.bnf.aep.utils;

public class JdbcUtils {
	
	public static final String USUARIO_POR_LOGIN = "SELECT login, senha, ativo, nome FROM usuario"
			+ " WHERE login = ?";

}
