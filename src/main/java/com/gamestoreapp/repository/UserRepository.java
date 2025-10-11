package com.gamestoreapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamestoreapp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//	  Optional<User> findByEmail(String email);
//	    
//	    // Check if email exists (for registration)
//	    boolean existsByEmail(String email);
//	    
//	    // Find user by email and password (for basic auth)
//	    Optional<User> findByEmailAndPassword(String email, String password);
	
	
	Optional<User> findByEmail(String email);
    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);


}
