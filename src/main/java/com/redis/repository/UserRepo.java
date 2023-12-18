package com.redis.repository;

import com.redis.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Map;

//@Repository
@Component
public interface UserRepo {

    void save(User user);

    Map<String, User> findAll();

    User findById(String id);

    void update(User user);

    String  delete(String id);
}
