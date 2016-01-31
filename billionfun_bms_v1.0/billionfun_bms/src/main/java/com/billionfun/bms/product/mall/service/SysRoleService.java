package com.billionfun.bms.product.mall.service;

import java.util.List;

import com.billionfun.bms.product.mall.model.SysRole;
import com.billionfun.bms.product.mall.vo.SysRoleVO;

public interface SysRoleService extends BaseService<SysRole,SysRoleVO,String>{
	List<SysRoleVO> search(SysRoleVO vo);
}
