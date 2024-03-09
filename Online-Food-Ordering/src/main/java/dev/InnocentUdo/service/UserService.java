package dev.InnocentUdo.service;

import dev.InnocentUdo.model.User;

public interface UserService {
    public User findUserByJwtToken(String jwt) throws Exception;
    public User findUserByEmail(String email) throws Exception;
}
