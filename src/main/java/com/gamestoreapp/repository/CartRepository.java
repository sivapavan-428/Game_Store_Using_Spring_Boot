package com.gamestoreapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gamestoreapp.entity.CartItem;
import com.gamestoreapp.entity.User;
import com.gamestoreapp.entity.Game;

@Repository
public interface CartRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUser(User user);
    void deleteByUserAndGame(User user, Game game);
    void deleteByUser(User user);
	Optional<CartItem> findByUserAndGame(User user, Game game);
}
