package com.imooc.web.async;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * d队列监听器
 * create by mxy on 2018/1/8
 */

@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    MockQueue mockQueue;

    @Autowired
    DefferResultHolder defferResultHolder;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        new Thread(() -> {
            while (true) {
                if (StringUtils.isNoneBlank(mockQueue.getCompeleteOrder())) {
                    String orderNum = mockQueue.getCompeleteOrder();
                    logger.info("订单处理完成" + orderNum);
                    defferResultHolder.getMap().get(orderNum).setResult("place order success");
                    mockQueue.setCompeleteOrder(null);
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }
}
