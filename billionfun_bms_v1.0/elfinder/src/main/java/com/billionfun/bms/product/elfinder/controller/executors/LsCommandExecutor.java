package com.billionfun.bms.product.elfinder.controller.executors;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import com.billionfun.bms.product.elfinder.controller.executor.AbstractJsonCommandExecutor;
import com.billionfun.bms.product.elfinder.controller.executor.CommandExecutor;
import com.billionfun.bms.product.elfinder.controller.executor.FsItemEx;
import com.billionfun.bms.product.elfinder.service.FsService;

public class LsCommandExecutor extends AbstractJsonCommandExecutor implements
		CommandExecutor
{
	@Override
	public void execute(FsService fsService, HttpServletRequest request,
			ServletContext servletContext, JSONObject json) throws Exception
	{
		String target = request.getParameter("target");
		String[] onlyMimes = request.getParameterValues("mimes[]");

		Map<String, FsItemEx> files = new HashMap<String, FsItemEx>();
		FsItemEx fsi = super.findItem(fsService, target);
		super.addChildren(files, fsi, onlyMimes);

		json.put("list", files2JsonArray(request, files.values()));
	}
}
