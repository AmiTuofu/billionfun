package com.billionfun.bms.product.elfinder.util;

import java.io.IOException;

import com.billionfun.bms.product.elfinder.controller.executor.FsItemEx;
import com.billionfun.bms.product.elfinder.service.FsItem;
import com.billionfun.bms.product.elfinder.service.FsService;

public abstract class FsServiceUtils
{
	public static FsItemEx findItem(FsService fsService, String hash) throws IOException
	{
		FsItem fsi = fsService.fromHash(hash);
		if (fsi == null)
		{
			return null;
		}

		return new FsItemEx(fsi, fsService);
	}
}
