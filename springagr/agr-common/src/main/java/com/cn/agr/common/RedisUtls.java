package com.cn.agr.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisUtls {

    /*@Autowired
    private static RedisTemplate redisTemplate;*/


    public static StringRedisTemplate stringRedisTemplate;

    @Autowired
    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        RedisUtls.stringRedisTemplate = stringRedisTemplate;
    }

    /*@Bean
    public RedisTemplate redisTemplateInit() {
        //设置序列化Key的实例化对象
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置序列化Value的实例化对象
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }*/

    public static void add(String key, String json) {
        ValueOperations<String, String> set = stringRedisTemplate.opsForValue();
        set.set(key, json);
    }

    public static String get(String key) {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        return operations.get(key);
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     *//*
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    *//**
     * 写入缓存设置时效时间
     *
     * @param key
     * @param value
     * @return
     *//*
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    *//**
     * 批量删除对应的value
     *
     * @param keys
     *//*
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    *//**
     * 批量删除key
     *
     * @param pattern
     *//*
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    *//**
     * 删除对应的value
     *
     * @param key
     *//*
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    *//**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     *//*
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    *//**
     * 读取缓存
     *
     * @param key
     * @return
     *//*
    public Object getObject(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    public void add(String key, String json) {
        ValueOperations<String, String> set = stringRedisTemplate.opsForValue();
        set.set(key, json);
    }

    public String getString(String key) {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        return operations.get(key);
    }

    *//**
     * 哈希 添加
     *
     * @param key
     * @param hashKey
     * @param value
     *//*
    public void hmSet(String key, Object hashKey, Object value) {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put(key, hashKey, value);
    }

    *//**
     * 哈希获取数据
     *
     * @param key
     * @param hashKey
     * @return
     *//*
    public Object hmGet(String key, Object hashKey) {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        return hash.get(key, hashKey);
    }

    *//**
     * 列表添加
     *
     * @param k
     * @param v
     *//*
    public void lPush(String k, Object v) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.rightPush(k, v);
    }

    *//**
     * 列表获取
     *
     * @param k
     * @param l
     * @param l1
     * @return
     *//*
    public List<Object> lRange(String k, long l, long l1) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.range(k, l, l1);
    }

    *//**
     * 集合添加
     *
     * @param key
     * @param value
     *//*
    public void add(String key, Object value) {
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        set.add(key, value);
    }

    *//**
     * 集合获取
     *
     * @param key
     * @return
     *//*
    public Set<Object> setMembers(String key) {
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        return set.members(key);
    }

    *//**
     * 有序集合添加
     *
     * @param key
     * @param value
     * @param scoure
     *//*
    public void zAdd(String key, Object value, double scoure) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        zset.add(key, value, scoure);
    }

    *//**
     * 有序集合获取
     *
     * @param key
     * @param scoure
     * @param scoure1
     * @return
     *//*
    public Set<Object> rangeByScore(String key, double scoure, double scoure1) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.rangeByScore(key, scoure, scoure1);
    }*/


}
