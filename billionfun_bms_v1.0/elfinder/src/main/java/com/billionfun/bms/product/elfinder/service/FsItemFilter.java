package com.billionfun.bms.product.elfinder.service;

import com.billionfun.bms.product.elfinder.controller.executor.FsItemEx;


/**
 * A FsItemFilter tells if a FsItem is matched or not
 * 
 * @author bluejoe
 *
 */
public interface FsItemFilter
{
	//TODO: bad designs: FsItemEx should not used here
	//top level interfaces should only know FsItem instead of FsItemEx
	public boolean accepts(FsItemEx item);
}