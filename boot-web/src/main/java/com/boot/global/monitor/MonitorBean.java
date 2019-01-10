package com.boot.global.monitor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class MonitorBean implements InitializingBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(MonitorBean.class);

    @Override
    public void afterPropertiesSet() {
        LOGGER.info("jvm 监控启动.....");
    }
}

