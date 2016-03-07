package com.billionfun.bms.product.mall.common.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.billionfun.bms.product.mall.common.ConfigInfo;
import com.billionfun.bms.product.mall.common.utils.EmailUtil;
import com.billionfun.bms.product.mall.service.SysEventService;
import com.billionfun.bms.product.mall.vo.SysEventVO;

@Component
public class EventNoticeTask {
	@Autowired
	private SysEventService eventService;
	@Autowired
	private ConfigInfo configInfo;
	
	@Scheduled(cron = "0 0/30 * * * ?")  
    public void notice() {  
        List<SysEventVO> listVos = eventService.getRemindList();
        Map<String, List<SysEventVO>> map = new HashMap<String, List<SysEventVO>>();
        String userId = "";
        List<SysEventVO> listRef = null;
        for (int i = 0; i < listVos.size(); i++) {
        	SysEventVO vo = listVos.get(i);
        	if(vo.getUserId()!=userId){
        		if(i!=0){
        			map.put(userId, listRef);
        		}
        		listRef = new ArrayList<SysEventVO>();
        		userId = vo.getUserId();
        	}
        	listRef.add(vo);
		}
        map.put(userId, listRef);
        
        for(Map.Entry<String, List<SysEventVO>> entry :map.entrySet()){
        	List<SysEventVO> list = entry.getValue();
        	Map model = new HashMap();
        	model.put("list", list);
        	EmailUtil.sendEmail(model, "事件提醒", configInfo.getVelocityEventRemind(),
    				new String[] { list.get(0).getEmail() }, new String[] {});
        }
    } 
}
