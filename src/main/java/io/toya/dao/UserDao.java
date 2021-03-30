package io.toya.dao;

import io.toya.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    List<User> listAll(@Param("nickname") String nickname);

    User getById(Integer id);

    int save(User user);

    int deleteById(String id);

    int update(User user);

}
