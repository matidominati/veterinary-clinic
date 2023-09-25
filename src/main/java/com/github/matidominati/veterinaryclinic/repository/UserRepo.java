package com.github.matidominati.veterinaryclinic.repository;

import com.github.matidominati.veterinaryclinic.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepo {
    User saveUser(User user);
    Optional<User> deleteUser(String username);
    Optional<User> editUser(String username, User updatedUser);
    Optional<User> findUserByUsername(String username);
    List<User> getAllUsers();
}

