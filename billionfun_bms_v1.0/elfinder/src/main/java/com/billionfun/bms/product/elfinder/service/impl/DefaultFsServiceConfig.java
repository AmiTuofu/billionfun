package com.billionfun.bms.product.elfinder.service.impl;

import com.billionfun.bms.product.elfinder.service.FsServiceConfig;

public class DefaultFsServiceConfig implements FsServiceConfig {
	private int _tmbWidth;

	public void setTmbWidth(int tmbWidth) {
		_tmbWidth = tmbWidth;
	}

	public int getTmbWidth() {
		return _tmbWidth;
	}
}
