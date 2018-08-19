package com.cn.agr.common.Thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class ThreadPoolUtil {

    private Logger logger = LoggerFactory.getLogger(ThreadPoolUtil.class);

    public static ThreadPoolExecutor threadPoolExecutor;

    public ThreadPoolUtil() {
        threadPoolExecutor = new ThreadPoolExecutor(5,10,200,TimeUnit.SECONDS,new LinkedBlockingQueue(10));
        logger.info("初始化线程池--> 线程池种数目：" + threadPoolExecutor.getPoolSize() + ",已经执行的线程数：" + threadPoolExecutor.getCompletedTaskCount());
    }

    public static ThreadPoolExecutor getExecutor() {
        return threadPoolExecutor;
    }

}
