package com.billionfun.bms.product.elfinder.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.billionfun.bms.product.elfinder.common.ConfigInfo;
import com.billionfun.bms.product.elfinder.controller.ConnectorController;
import com.billionfun.bms.product.elfinder.controller.executor.CommandExecutorFactory;
import com.billionfun.bms.product.elfinder.controller.executor.DefaultCommandExecutorFactory;
import com.billionfun.bms.product.elfinder.controller.executors.MissingCommandExecutor;
import com.billionfun.bms.product.elfinder.localfs.LocalFsVolume;
import com.billionfun.bms.product.elfinder.service.impl.DefaultFsService;
import com.billionfun.bms.product.elfinder.service.impl.DefaultFsServiceConfig;
import com.billionfun.bms.product.elfinder.service.impl.FsSecurityCheckForAll;
import com.billionfun.bms.product.elfinder.service.impl.StaticFsServiceFactory;

public class ConnectorServlet extends HttpServlet {
	// core member of this Servlet
	ConnectorController _connectorController;
	/**
	 * create a command executor factory
	 * 
	 * @param config
	 * @return
	 */
	protected CommandExecutorFactory createCommandExecutorFactory(
			ServletConfig config) {
		DefaultCommandExecutorFactory defaultCommandExecutorFactory = new DefaultCommandExecutorFactory();
		defaultCommandExecutorFactory
				.setClassNamePattern("com.billionfun.bms.product.elfinder.controller.executors.%sCommandExecutor");
		defaultCommandExecutorFactory
				.setFallbackCommand(new MissingCommandExecutor());
		return defaultCommandExecutorFactory;
	}

	/**
	 * create a connector controller
	 * 
	 * @param config
	 * @return
	 */
	protected ConnectorController createConnectorController(ServletConfig config) {
		ConnectorController connectorController = new ConnectorController();

		connectorController
				.setCommandExecutorFactory(createCommandExecutorFactory(config));
		connectorController.setFsServiceFactory(createServiceFactory(config));

		return connectorController;
	}

	protected DefaultFsService createFsService() {
		
		DefaultFsService fsService = new DefaultFsService();
		fsService.setSecurityChecker(new FsSecurityCheckForAll());
		
		DefaultFsServiceConfig serviceConfig = new DefaultFsServiceConfig();
		serviceConfig.setTmbWidth(80);
		fsService.setServiceConfig(serviceConfig);
		
		fsService.addVolume("A",
				createLocalFsVolume("My Files", new File(ConfigInfo.config.getProperty("volume.local.myfiles.a"))));
		fsService.addVolume(
				"B",
				createLocalFsVolume("Shared", new File(ConfigInfo.config.getProperty("volume.local.shared.b"))));

		return fsService;
	}

	private LocalFsVolume createLocalFsVolume(String name, File rootDir) {
		LocalFsVolume localFsVolume = new LocalFsVolume();
		localFsVolume.setName(name);
		localFsVolume.setRootDir(rootDir);
		return localFsVolume;
	}

	/**
	 * create a service factory
	 * 
	 * @param config
	 * @return
	 */
	protected StaticFsServiceFactory createServiceFactory(ServletConfig config) {
		StaticFsServiceFactory staticFsServiceFactory = new StaticFsServiceFactory();
		DefaultFsService fsService = createFsService();

		staticFsServiceFactory.setFsService(fsService);
		return staticFsServiceFactory;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		_connectorController.connector(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		_connectorController.connector(req, resp);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		_connectorController = createConnectorController(config);
	}
}
