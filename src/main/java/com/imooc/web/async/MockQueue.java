package com.imooc.web.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 模拟消息处理队列
 * create by mxy on 2018/1/8
 */


@Component
public class MockQueue {

    private Logger logger = LoggerFactory.getLogger(getClass());


    private String placeOrder;
    private String compeleteOrder;

    public String getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(String placeOrder) throws Exception {

        new Thread(() -> {
            logger.info("接到订单" + placeOrder);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.compeleteOrder = placeOrder;
            logger.info("订单处理完成" + placeOrder);
        }).start();


    }

    public String getCompeleteOrder() {
        return compeleteOrder;
    }

    public void setCompeleteOrder(String compeleteOrder) {
        this.compeleteOrder = compeleteOrder;
    }
}
