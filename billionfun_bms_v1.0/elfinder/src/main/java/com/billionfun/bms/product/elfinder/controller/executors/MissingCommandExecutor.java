package com.billionfun.bms.product.elfinder.controller.executors;

import org.json.JSONArray;
import org.json.JSONObject;

import com.billionfun.bms.product.elfinder.controller.ErrorException;
import com.billionfun.bms.product.elfinder.controller.executor.AbstractJsonCommandExecutor;
import com.billionfun.bms.product.elfinder.controller.executor.CommandExecutor;
import com.billionfun.bms.product.elfinder.service.FsService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * This is a command that should be executed when a matching command can't be found.
 */
public class MissingCommandExecutor extends AbstractJsonCommandExecutor implements CommandExecutor
{
    @Override
    protected void execute(FsService fsService, HttpServletRequest request, ServletContext servletContext, JSONObject json) throws Exception
    {
        String cmd = request.getParameter("cmd");
        throw new ErrorException("errUnknownCmd", cmd);
   }
}
