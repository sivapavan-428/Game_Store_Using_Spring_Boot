package com.gamestoreapp.repository;

import com.gamestoreapp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
//    // Find all orders for a user
//    List<Order> findByUserIdOrderByOrderDateDesc(Long userId);
//    
//    // Find orders by status
//    List<Order> findByUserIdAndStatusOrderByOrderDateDesc(Long userId, Order.OrderStatus status);
//    
//    // ✅ FIXED: Use proper JPA syntax with Pageable
//    @Query("SELECT o FROM Order o WHERE o.user.id = :userId ORDER BY o.orderDate DESC")
//    List<Order> findRecentOrdersByUserId(@Param("userId") Long userId, org.springframework.data.domain.Pageable pageable);
//    
//    // Count orders by user
//    long countByUserId(Long userId);
//    
//    // ✅ Alternative: Get top N recent orders using method name
//    List<Order> findTop5ByUserIdOrderByOrderDateDesc(Long userId);
	
	List<Order> findByUserId(Long userId);
}