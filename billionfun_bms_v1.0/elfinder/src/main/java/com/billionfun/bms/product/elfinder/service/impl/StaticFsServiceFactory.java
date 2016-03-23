package com.billionfun.bms.product.elfinder.service.impl;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.billionfun.bms.product.elfinder.service.FsService;
import com.billionfun.bms.product.elfinder.service.FsServiceFactory;

/**
 * A StaticFsServiceFactory always returns one FsService, despite of whatever it
 * is requested
 * 
 * @author bluejoe
 * 
 */
public class StaticFsServiceFactory implements FsServiceFactory {
	FsService _fsService;

	public FsService getFileService(HttpServletRequest request,
			ServletContext servletContext) {
		return _fsService;
	}

	public FsService getFsService() {
		return _fsService;
	}

	public void setFsService(FsService fsService) {
		_fsService = fsService;
	}
}
