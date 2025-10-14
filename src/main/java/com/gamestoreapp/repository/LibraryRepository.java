package com.gamestoreapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gamestoreapp.entity.LibraryItem;

@Repository
public interface LibraryRepository extends JpaRepository<LibraryItem, Long> {
    List<LibraryItem> findByUserId(Long userId);
}
