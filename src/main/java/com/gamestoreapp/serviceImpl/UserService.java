package com.gamestoreapp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamestoreapp.entity.User;
import com.gamestoreapp.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public List<User> getUsersByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    public List<User> getUsersByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    public User updateEmail(Long id, String email) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            User user = optional.get();
            user.setEmail(email);
            return userRepository.save(user);
        }
        return null;
    }

    public User updatePassword(Long id, String currentPassword, String newPassword) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            User user = optional.get();
            if (user.getPassword().equals(currentPassword)) {
                user.setPassword(newPassword);
                return userRepository.save(user);
            }
        }
        return null;
    }

    public User updateFirstName(Long id, String firstName) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            User user = optional.get();
            user.setFirstName(firstName);
            return userRepository.save(user);
        }
        return null;
    }

    public User updateLastName(Long id, String lastName) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            User user = optional.get();
            user.setLastName(lastName);
            return userRepository.save(user);
        }
        return null;
    }
}
