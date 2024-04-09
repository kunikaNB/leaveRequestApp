package com.kunika.leaveRequestApp.Service;

import com.kunika.leaveRequestApp.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User findByUsername(String username);

    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    void deleteUser(Long id);

    User updateUser(Long id, User user);

    User createUser(User user);
}
