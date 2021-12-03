package com.cpu_makes.folder.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cpu_makes.folder.Entity.UserDetails;

@Service
public interface MainService {
	public abstract Optional<UserDetails> checkUser(String mail,String pass);
}
