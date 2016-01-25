package com.billionfun.bms.product.mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billionfun.bms.product.mall.common.utils.StringUtil;
import com.billionfun.bms.product.mall.dao.SysFuncDao;
import com.billionfun.bms.product.mall.model.SysFunc;
import com.billionfun.bms.product.mall.service.SysFuncService;
import com.billionfun.bms.product.mall.vo.SysFuncVO;

@Service("funcService")
public class SysFuncServiceImpl extends BaseServiceImpl<SysFunc, String> implements SysFuncService{
	@Autowired
	private SysFuncDao funcDao;
	
	
	public List<SysFuncVO> query(SysFuncVO funcVo){
		List<SysFunc> listFunc = funcDao.getListByPage(funcVo);
		List<SysFuncVO> listFuncVo = new ArrayList<SysFuncVO>();
		if(!StringUtil.empty(listFunc)){
			for (SysFunc funcRef : listFunc) {
				SysFuncVO funcVoRef = new SysFuncVO();
				BeanUtils.copyProperties(funcRef, funcVoRef);
				listFuncVo.add(funcVoRef);
			}
		}
		return listFuncVo;
	}

}
