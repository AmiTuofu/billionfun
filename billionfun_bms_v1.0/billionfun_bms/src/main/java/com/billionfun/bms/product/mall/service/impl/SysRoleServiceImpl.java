package com.billionfun.bms.product.mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billionfun.bms.product.mall.common.utils.StringUtil;
import com.billionfun.bms.product.mall.dao.SysRoleDao;
import com.billionfun.bms.product.mall.model.SysRole;
import com.billionfun.bms.product.mall.service.SysRoleService;
import com.billionfun.bms.product.mall.vo.SysRoleVO;

@Service("roleService")
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole,SysRoleVO, String> implements SysRoleService{
	@Autowired
	private SysRoleDao roleDao;
	
	public List<SysRoleVO> search(SysRoleVO vo) {
		List<SysRole> list = roleDao.getListByPage(vo);
		List<SysRoleVO> listVo = new ArrayList<SysRoleVO>();
		if(!StringUtil.empty(list)){
			for (SysRole ref : list) {
				SysRoleVO voRef = new SysRoleVO();
				BeanUtils.copyProperties(ref, voRef);
				listVo.add(voRef);
				
			}
		}
		return listVo;
	}

}
