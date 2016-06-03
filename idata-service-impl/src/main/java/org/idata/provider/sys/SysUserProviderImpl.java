/**
 * 
 */
package org.idata.provider.sys;

import java.util.Date;
import java.util.Map;

import org.idata.core.config.Resources;
import org.idata.core.support.dubbo.BaseProviderImpl;
import org.idata.core.support.dubbo.spring.annotation.DubboService;
import org.idata.core.support.login.ThirdPartyUser;
import org.idata.core.util.SecurityUtil;
import org.idata.mybatis.generator.dao.SysUserMapper;
import org.idata.mybatis.generator.model.SysUser;
import org.idata.mybatis.sys.dao.SysUserExpandMapper;
import org.idata.mybatis.sys.model.SysUserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.github.pagehelper.PageInfo;

/**
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:19:19
 */
@DubboService(interfaceClass = SysUserProvider.class)
@CacheConfig(cacheNames = "sysUser")
public class SysUserProviderImpl extends BaseProviderImpl<SysUser> implements SysUserProvider {
	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private SysUserExpandMapper sysUserExpandMapper;

	@CachePut
	@Transactional
	public SysUser update(SysUser record) {
		if (record.getId() == null) {
			record.setUsable(1);
			record.setCreateTime(new Date());
			sysUserMapper.insert(record);
		} else {
			sysUserMapper.updateByPrimaryKey(record);
		}
		return record;
	}

	@CachePut
	@Transactional
	public void delete(Integer id) {
		SysUser record = queryById(id);
		Assert.notNull(record, String.format(Resources.getMessage("USER_IS_NULL"), id));
		record.setUsable(0);
		update(record);
	}

	@Cacheable
	public SysUser queryById(Integer id) {
		return sysUserMapper.selectByPrimaryKey(id);
	}

	public PageInfo<SysUser> query(Map<String, Object> params) {
		return null;
	}


	/** 查询第三方帐号用户Id */
	@Cacheable
	public String queryUserIdByThirdParty(String openId, String provider) {
		return sysUserExpandMapper.queryUserIdByThirdParty(provider, openId);
	}

	// 加密
	public String encryptPassword(String password) {
		return SecurityUtil.encryptMd5(SecurityUtil.encryptSHA(password));
	}

	/** 保存第三方帐号 */
	@Transactional
	public SysUser insertThirdPartyUser(ThirdPartyUser thirdPartyUser) {
//		SysUser sysUser = new SysUser();
//		sysUser.setSex(0);
//		sysUser.setUserType(1);
//		sysUser.setPassword(this.encryptPassword("123456"));
//		sysUser.setUserName(thirdPartyUser.getUserName());
//		sysUser.setAvatar(thirdPartyUser.getAvatarUrl());
//		// 初始化第三方信息
//		SysUserThirdparty thirdparty = new SysUserThirdparty();
//		thirdparty.setProvider(thirdPartyUser.getProvider());
//		thirdparty.setOpenId(thirdPartyUser.getOpenid());
//		thirdparty.setCreateTime(new Date());
//
//		this.update(sysUser);
//		sysUser.setAccount(thirdparty.getProvider() + sysUser.getId());
//		this.update(sysUser);
//		thirdparty.setUserId(sysUser.getId());
//		thirdpartyMapper.insert(thirdparty);
//		return sysUser;
		return null;
	}

	@Override
	public PageInfo<SysUserBean> queryBeans(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}
}
