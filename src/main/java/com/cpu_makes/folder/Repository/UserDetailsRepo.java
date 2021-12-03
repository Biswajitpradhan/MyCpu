package com.cpu_makes.folder.Repository;

import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cpu_makes.folder.Entity.UserDetails;

@Repository
public interface UserDetailsRepo extends MongoRepository<UserDetails, Integer>{
	Optional<UserDetails> findByEmailAndPassword(String email,String password);
}
