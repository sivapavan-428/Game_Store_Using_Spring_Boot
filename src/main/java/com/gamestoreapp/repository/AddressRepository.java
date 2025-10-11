package com.gamestoreapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamestoreapp.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

//	 List<Address> findByUserId(Long userId);
//	    
//	    // Find address by user and address ID
//	    Optional<Address> findByUserIdAndId(Long userId, Long addressId);
//	    
//	    // Delete address by user and address ID
//	    void deleteByUserIdAndId(Long userId, Long addressId);
//	    
//	    // Check if address belongs to user
//	    boolean existsByUserIdAndId(Long userId, Long addressId);
	
	List<Address> findByUserId(Long userId);
}
