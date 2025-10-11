package com.gamestoreapp.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gamestoreapp.entity.OrderItem;
import com.gamestoreapp.repository.OrderItemRepository;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public OrderItem addOrderItem(OrderItem item) {
        return orderItemRepository.save(item);
    }

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}
