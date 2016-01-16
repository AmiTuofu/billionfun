package com.billionfun.bms.product.mall.common.utils;

import java.util.List;

import com.alibaba.fastjson.JSON;

public class JSONUtil {
	/**
	 * 
	 * @Title: list2Json 
	 * @Description: TODO
	 * @param @param list
	 * @param @return 
	 * @return String
	 * @throws
	 */
	public static String list2Json(List list){  
        String jsonText = JSON.toJSONString(list, true);  
        return jsonText;
    }  
	public static void main(String[] args) {

	}
}
