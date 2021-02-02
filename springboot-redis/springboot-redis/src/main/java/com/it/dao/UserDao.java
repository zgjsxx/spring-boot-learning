package com.it.dao;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

import com.it.entity.User;

@Repository
public class UserDao {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Resource(name="stringRedisTemplate")
    ValueOperations<String, String> valOpsStr;

    public void save(String key,String value){
        stringRedisTemplate.setKeySerializer(new StringRedisSerializer());
        valOpsStr.set(key, value);
    }

    public String getByKey(String key){
        String value = valOpsStr.get(key);
        return value;
    }


    @Autowired
    RedisTemplate<Object, Object> redisTemplate;
    @Resource(name="redisTemplate")
    ValueOperations<Object, Object> valOps;

    public void save(User user){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        valOps.set(user.getId(), user);
    }

    public User getById(String id){
        User user = (User) valOps.get(id);
        return user;
    }

}