package com.billionfun.bms.product.mall.common.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class TestTask {
	@Scheduled(cron = "0/2 * * * * *")  
    public void process() {  
        System.out.println("job run111111111");  
    } 
}
