package dev.Innocent.service;

import dev.Innocent.model.User;

import java.util.List;

public interface UserService {
    public User getUserProfile(String jwt);
    public List<User> getAllUsers();
}
