package com.imooc.web.async;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * create by mxy on 2018/1/8
 */
@RestController
@RequestMapping
public class AsyncController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    MockQueue mockQueue;

    @Autowired
    DefferResultHolder defferResultHolder;

    @RequestMapping("/order")
    public DeferredResult<String> order() throws Exception {
        logger.info("主线程开始");
        String orderNum = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNum);
        DeferredResult result = new DeferredResult();
        defferResultHolder.getMap().put(orderNum, result);
        /*Callable<String> result=new Callable<String>() {
            @Override
            public String call() throws Exception {

                logger.info("副线程开始");
                Thread.sleep(1000);
                logger.info("副线程结束");
                return "success";
            }
        };*/
        logger.info("主线程结束");
        return result;
    }
}
