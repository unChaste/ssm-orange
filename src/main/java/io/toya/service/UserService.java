package io.toya.service;

import io.toya.entity.User;

import java.util.List;

public interface UserService {
    List<User> listAll(String nickname);

    User getById(Integer id);

    int save(User user);

    int deleteById(String id);

    int update(User user);

    User getByUsername(String username);
}
