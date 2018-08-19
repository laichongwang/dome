package com.cn.agr.common;

import com.cn.agr.common.DTO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MongodbRepository {

    @Autowired
    public MongoTemplate mongoTemplate;

    public void save(User obj) {
        // mongoTemplate.insert(obj);
        mongoTemplate.save(obj);
    }
}
