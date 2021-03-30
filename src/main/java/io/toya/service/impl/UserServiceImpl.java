package io.toya.service.impl;

import io.toya.dao.UserDao;
import io.toya.entity.User;
import io.toya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> listAll(String nickname) {
        List<User> userList = userDao.listAll(nickname);
        return userList;
    }

    @Override
    public User getById(Integer id) {
        User user = userDao.getById(id);
        return user;
    }

    @Override
    public int save(User user) {
        int rows = userDao.save(user);
        System.out.println(user);
        return rows;
    }

    @Override
    public int deleteById(String id) {
        int rows = userDao.deleteById(id);
        return rows;
    }

    @Override
    public int update(User user) {
        user.setCreateTime(null);
        int rows = userDao.update(user);
        return rows;
    }
}
