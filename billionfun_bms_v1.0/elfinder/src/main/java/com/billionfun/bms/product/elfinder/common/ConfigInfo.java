package com.billionfun.bms.product.elfinder.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: 公共配置类 
 * @Description: TODO 
 * @author  AmiTuofu
 * @date  2016年3月15日 下午10:27:43 
 *
 */
@Component("configInfo")
public class ConfigInfo {
	@Value("${volume.local.myfiles.a}")
	private String volumeLocalMyfilesA;
	
	@Value("${volume.local.shared.b}")
	private String volumeLocalSharedB;

	public String getVolumeLocalMyfilesA() {
		return volumeLocalMyfilesA;
	}

	public void setVolumeLocalMyfilesA(String volumeLocalMyfilesA) {
		this.volumeLocalMyfilesA = volumeLocalMyfilesA;
	}

	public String getVolumeLocalSharedB() {
		return volumeLocalSharedB;
	}

	public void setVolumeLocalSharedB(String volumeLocalSharedB) {
		this.volumeLocalSharedB = volumeLocalSharedB;
	}
	
}
