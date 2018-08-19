package com.cn.agr.services;

import com.cn.agr.common.DTO.User;
import com.cn.agr.common.MongodbRepository;
import com.cn.agr.common.RedisUtls;
import com.cn.agr.common.Thread.ThreadPoolUtil;
import com.cn.agr.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.ThreadPoolExecutor;

@Service
public class ApplyService {

    @Autowired
    private Config.CommonPrint commonPrint;

    @Autowired
    private MongodbRepository mongodbRepository;

    @Autowired
    private ThreadPoolUtil threadPoolUtil;

    public String getConfigName() {
        return commonPrint.getUserName() + commonPrint.getPswd();
    }

    public String getConfigPswd() {
        return commonPrint.getPswd();
    }

    public String getRedisName(String key) {
        return RedisUtls.get(key);
    }

    public String saveRedisName(String key, String val) {
        RedisUtls.add(key, val);
        return key;
    }

    public String saveMongodb(String obj) {
        User user = new User();
        user.setName(obj);
        user.setAge(obj);
        user.setJob(obj);
        user.setPassword(obj);
        mongodbRepository.save(user);
        return obj;
    }

    public void runThread() {
        Random random = new Random();
        ThreadTest threadTest = new ThreadTest(random.nextInt());
        ThreadPoolExecutor executor = ThreadPoolUtil.threadPoolExecutor;
        executor.submit(threadTest);
        System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                executor.getQueue().size()+"，已执行完的任务数目："+executor.getCompletedTaskCount());
    }

    class ThreadTest implements Runnable {
        private int num = 0;
        ThreadTest(int num) {
            this.num = num;
        }
        public void run() {
            System.out.println("线程池："+num);
        }

    }

}
