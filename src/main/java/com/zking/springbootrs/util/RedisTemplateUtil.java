package com.zking.springbootrs.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class RedisTemplateUtil {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 操作String类型的set/get
     */
    public void set(String key,Object vaule){
        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key,vaule);
    }
    public Object get(String key){
        return redisTemplate.opsForValue().get(key);
    }


    /**
     * 操作List链表类型的set/get
     */
    public void setList(String key, List value) {
        ListOperations<String, Object> listOperations = redisTemplate.opsForList();
        listOperations.leftPush(key, value);
    }
    public Object getList(String key) {
        return redisTemplate.opsForList().leftPop(key);
    }


    /**
     * 操作set集合类型的set/get
     */
    public void setSet(String key, Set<?> value){
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add(key,value);
    }
    public Object getSet(String key){
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 操作hash对象类型的set/get
     */
    public void setHash(String key, Map<String,?> value){
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.putAll(key,value);
    }
    public Object getHash(String key){
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 根据key删除数据
     */
    public void delete(String key){
        redisTemplate.delete(key);
    }
}
