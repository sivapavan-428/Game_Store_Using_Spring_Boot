package com.gamestoreapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamestoreapp.entity.Cart;
import com.gamestoreapp.entity.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    
    // Find cart by user ID
//    Optional<Cart> findByUserId(Long userId);
//    
//    // Check if cart exists for user
//    boolean existsByUserId(Long userId);
//    
//    // Delete cart by user ID
//    void deleteByUserId(Long userId);
	
//	Cart findByUserId(Long userId);
	Optional<Cart> findByUserId(Long userId);

}