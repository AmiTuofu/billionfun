package com.billionfun.bms.product.elfinder.controller.executor;

public interface CommandExecutor
{
	void execute(CommandExecutionContext commandExecutionContext) throws Exception;
}
