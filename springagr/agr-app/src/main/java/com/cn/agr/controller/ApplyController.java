package com.cn.agr.controller;

import com.cn.agr.services.ApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController("/agr")
public class ApplyController {

    @Autowired
    private ApplyService applyService;

    @ApiOperation(value = "获取配置文件用户名", notes = "applyQueryConfigName")
    @RequestMapping(value = "/applyQueryConfigName", method = RequestMethod.POST)
    public String applyQueryConfigName() {
        return applyService.getConfigName();
    }

    @ApiOperation(value = "获取配置文密码", notes = "applyQueryConfigPswd")
    @RequestMapping(value = "/applyQueryConfigPswd", method = RequestMethod.POST)
    public String applyQueryConfigPswd() {
        return applyService.getConfigPswd();
    }

    @ApiOperation(value = "redis获取name", notes = "getRedisName")
    @RequestMapping(value = "/getRedisName", method = RequestMethod.POST)
    public String getRedisName(String key) {
        return applyService.getRedisName(key);
    }

    @ApiOperation(value = "redis保存Name", notes = "saveNameRedis")
    @RequestMapping(value = "/saveNameRedis", method = RequestMethod.POST)
    public String saveNameRedis(String key, String val) {
        return applyService.saveRedisName(key,val);
    }

    @ApiOperation(value = "mongodb保存Name", notes = "saveMongodb")
    @RequestMapping(value = "/saveMongodb", method = RequestMethod.POST)
    public String saveMongodb(String val) {
        return applyService.saveMongodb(val);
    }

    @ApiOperation(value = "多线程于线程池", notes = "runThreadNumber")
    @RequestMapping(value = "/runThreadNumber", method = RequestMethod.POST)
    public void runThreadNumber () {
        applyService.runThread();
    }

    @RequestMapping(value = "/selectGetParames", method = RequestMethod.GET)
    public String selectGetParames(@RequestParam("name") String name) {
        return name;
    }

}
