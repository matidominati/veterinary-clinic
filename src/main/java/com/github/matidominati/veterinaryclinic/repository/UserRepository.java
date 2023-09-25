package com.github.matidominati.veterinaryclinic.repository;

import com.github.matidominati.veterinaryclinic.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements UserRepo {
    private final List<User> users = new ArrayList<>();

    @Override
    public User saveUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public Optional<User> deleteUser(String username) {
        Optional<User> userToDelete = findUserByUsername(username);
        if (userToDelete.isEmpty()) {
            return Optional.empty();
        }
        users.remove(userToDelete.get());
        return userToDelete;
    }

    @Override
    public Optional<User> editUser(String username, User updatedUser) {
        Optional<User> optionalUser = findUserByUsername(username);
        if (optionalUser.isEmpty()) {
            return Optional.empty();
        }
        User userToEdit = optionalUser.get();
        userToEdit.setPassword(updatedUser.getPassword());
        userToEdit.setName(updatedUser.getName());
        userToEdit.setSurname(updatedUser.getSurname());
        return Optional.ofNullable(userToEdit);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername() != null && user.getUsername().equals(username))
                .findFirst();
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
}
