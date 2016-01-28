package com.billionfun.bms.product.mall.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billionfun.bms.product.mall.dao.SysFuncDao;
import com.billionfun.bms.product.mall.dao.SysUserDao;
import com.billionfun.bms.product.mall.model.SysFunc;
import com.billionfun.bms.product.mall.model.SysRole;
import com.billionfun.bms.product.mall.model.SysUser;
import com.billionfun.bms.product.mall.service.SysUserService;
import com.billionfun.bms.product.mall.vo.SysUserVO;

@Service("userService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUser,SysUserVO, String> implements SysUserService {
	
	@Autowired
	private SysUserDao userDao;
	
	@Autowired
	private SysFuncDao funcDao;


	public List findAll() {
		return userDao.findAll("from SysUser");
	}
	
	
	public boolean isExsit(String username,String email,String mobile) {
		boolean sign = false;
		SysUser user = userDao.loadUser(username, email, mobile);
		if(user!=null){
			sign = true;
		}
		return sign;
	}

	public SysUser loadUser(String username) {
		SysUser user = userDao.loadUserByUsername(username);
		List<SysRole> listRoles = user.getListRoles();
		Map<String, SysFunc> userFuncMap = new HashMap<String, SysFunc>();
		for (SysRole sysRole : listRoles) {
			List<SysFunc> listFuncs = sysRole.getListFuncs();
			for (SysFunc sysFunc : listFuncs) {
				userFuncMap.put(sysFunc.getId(), sysFunc);
			}
		}
		List<SysFunc> listRef = new ArrayList<SysFunc>();
		for (Map.Entry<String, SysFunc> entry : userFuncMap.entrySet()) {
			String funcId = entry.getKey();
			SysFunc func = entry.getValue();
			listRef.add(func);
			
		}
		user.setListFuncs(listRef);
		return user;
	}
	
	/**
	 * 
	 * @Title: 递归获取用户权限 
	 * @Description: TODO	一步一步来,从简单开始
	 * @param @param parentId
	 * @param @param userFuncMap
	 * @param @return 
	 * @return List<SysFunc>
	 * @throws
	 */
	private List<SysFunc> getFuncList(String parentId,Map<String, SysFunc> userFuncMap){
		List<SysFunc> list = funcDao.loadFunc(parentId);
		if(list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				SysFunc func = list.get(i);
				//1.与用户权限比较，进行筛选
//				if(userFuncMap.containsKey(func.getId())){
//					listRef.add(func);
//				}
	//			List listFunc = getFuncList(func.getId(),userFuncMap);
				//得到系统所有权限
			//	func.setListFuncs(getFuncList(func.getId(),userFuncMap));
				List<SysFunc> list2 = getFuncList(func.getId(),userFuncMap);
				List<SysFunc> listRef = new ArrayList<SysFunc>();
				for (int j = 0; j < list2.size(); j++) {
					SysFunc sysFunc2 = list2.get(j);
					if(userFuncMap.containsKey(sysFunc2.getId())){
						listRef.add(sysFunc2);
					}
				}
				func.setListFuncs(listRef);
			}
		}
		return list;
	}
}
