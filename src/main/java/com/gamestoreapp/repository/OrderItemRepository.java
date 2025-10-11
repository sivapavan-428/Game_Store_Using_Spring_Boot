package com.gamestoreapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gamestoreapp.entity.OrderItem;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    
//    // Find all order items for an order
//    List<OrderItem> findByOrder_Id(Long orderId);
//    
//    // Find order items by game (for analytics)
//    List<OrderItem> findByGameId(Long gameId);
//    
//    // ✅ FIXED: Use the relationship path
//    @Query("SELECT oi FROM OrderItem oi WHERE oi.order.id = :orderId")
//    List<OrderItem> findByOrderId(@Param("orderId") Long orderId);
	
	List<OrderItem> findByOrderId(Long orderId);
}
