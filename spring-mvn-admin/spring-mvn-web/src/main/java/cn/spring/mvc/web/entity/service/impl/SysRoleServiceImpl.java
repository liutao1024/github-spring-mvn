package cn.spring.mvc.web.entity.service.impl;

import org.springframework.stereotype.Service;

import cn.spring.mvc.base.BaseServiceImpl;
import cn.spring.mvc.web.entity.SysRole;
import cn.spring.mvc.web.entity.service.SysRoleService;

@Service("SysRoleService")
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole> implements SysRoleService{
	@Override
	public SysRole selectOneByPrimeKey(String regist_cd, String auth_type, String role_cd){
		SysRole sysRole = new SysRole(regist_cd, auth_type, role_cd);
		return this.selectOneEntity(sysRole);
		
	}
	
}
