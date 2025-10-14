//package com.gamestoreapp.serviceImpl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.gamestoreapp.entity.CartItem;
//import com.gamestoreapp.repository.CartItemRepository;
//
//@Service
//public class CartItemService {
//
//    @Autowired
//    private CartItemRepository cartItemRepository;
//
//    // Add a new cart item
//    public CartItem addCartItem(CartItem item) {
//        return cartItemRepository.save(item);
//    }
//
//    // Get all cart items
//    public List<CartItem> getAllCartItems() {
//        return cartItemRepository.findAll();
//    }
//
//    // Get cart item by ID
//    public CartItem getCartItemById(Long id) {
//        return cartItemRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Cart item not found"));
//    }
//
//    // Delete cart item by ID
//    public void removeItem(Long id) {
//        cartItemRepository.deleteById(id);
//    }
//
//    // Update quantity of a cart item
//    public CartItem updateCartItemQuantity(Long id, int quantity) {
//        CartItem item = getCartItemById(id);
////        item.setQuantity(quantity);
//        return cartItemRepository.save(item);
//    }
//
//    // Get all cart items for a specific user
////    public List<CartItem> getCartItemsByUserId(Long userId) {
////        return cartItemRepository.findByCartUserId(userId);
////    }
//}
