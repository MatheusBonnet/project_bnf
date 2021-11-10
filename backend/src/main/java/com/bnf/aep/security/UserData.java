package com.bnf.aep.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bnf.aep.entities.Users;

public class UserData implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private final Optional<Users> usuario;

    public UserData(Optional<Users> usuario2) {
        this.usuario = usuario2;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return usuario.orElse(new Users()).getPassword();
    }

    @Override
    public String getUsername() {
    	return usuario.orElse(new Users()).getCpf();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

