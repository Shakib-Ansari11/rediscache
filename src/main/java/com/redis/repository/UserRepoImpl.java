package com.redis.repository;

import com.redis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Component
@Repository
@Service
public class UserRepoImpl implements UserRepo{

    private HashOperations<String, String, User> hashOperations;

    public UserRepoImpl(RedisTemplate<String, User> redisTemplate) {
        hashOperations = redisTemplate.opsForHash();
    }
    @Override
    public void save(User user) {
          hashOperations.put("User", user.getId(), user);
    }

    @Override
    public Map<String, User> findAll() {
        return hashOperations.entries("User");
    }

    @Override
    public User findById(String id) {
        User user = hashOperations.get("User", id);
        return user;
    }

    @Override
    public void update(User user) {
          save(user);
    }

    @Override
    public String delete(String id) {
        hashOperations.delete("User",id);
        return "deleted";

    }
}
