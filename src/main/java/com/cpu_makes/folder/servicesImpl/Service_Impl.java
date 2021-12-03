package com.cpu_makes.folder.servicesImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cpu_makes.folder.Entity.UserDetails;
import com.cpu_makes.folder.Repository.UserDetailsRepo;
import com.cpu_makes.folder.services.MainService;


@Service
public class Service_Impl implements MainService{
		

	
	private UserDetailsRepo ud;
	
	
	public Service_Impl(UserDetailsRepo ud) {
	
		this.ud = ud;
	}


	@Override
	public Optional<UserDetails> checkUser(String mail, String pass) {
		// TODO Auto-generated method stub
		return ud.findByEmailAndPassword(mail, pass);
		
	
	}

}
