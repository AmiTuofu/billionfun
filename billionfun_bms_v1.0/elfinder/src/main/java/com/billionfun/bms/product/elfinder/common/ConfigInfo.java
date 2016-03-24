package com.billionfun.bms.product.elfinder.common;

import java.util.Properties;

import com.billionfun.bms.product.elfinder.util.PropertiesUtil;

/**
 * 
 * @ClassName: 公共配置类 
 * @Description: TODO 
 * @author  AmiTuofu
 * @date  2016年3月15日 下午10:27:43 
 *
 */
public class ConfigInfo {
	public static Properties config = null;
	static{
		PropertiesUtil pro = new PropertiesUtil();
		config = pro.getProperties("/config.properties");
	}
}
