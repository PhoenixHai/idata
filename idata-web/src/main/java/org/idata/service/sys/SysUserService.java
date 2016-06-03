package org.idata.service.sys;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.idata.core.config.Resources;
import org.idata.core.support.BaseService;
import org.idata.core.support.login.LoginHelper;
import org.idata.core.support.login.ThirdPartyUser;
import org.idata.core.util.SecurityUtil;
import org.idata.mybatis.generator.model.SysUser;
import org.idata.mybatis.sys.model.SysUserBean;
import org.idata.provider.sys.SysUserProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.github.pagehelper.PageInfo;

/**
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:47:21
 */
@Service
public class SysUserService extends BaseService<SysUserProvider, SysUser> {
	@Autowired
	public void setProvider(SysUserProvider provider) {
		this.provider = provider;
	}

	/** 修改用户信息 */
	public void updateUserInfo(SysUser sysUser) {
		Assert.notNull(sysUser.getId(), Resources.getMessage("USER_ID_IS_NULL"));
		Assert.notNull(sysUser.getAccount(), Resources.getMessage("ACCOUNT_IS_NULL"));
		SysUser user = provider.queryById(sysUser.getId());
		Assert.notNull(user, String.format(Resources.getMessage("USER_IS_NULL"), sysUser.getId()));
		sysUser.setPassword(user.getPassword());
		provider.update(sysUser);
	}

	public PageInfo<SysUserBean> queryBeans(Map<String, Object> params) {
		return provider.queryBeans(params);
	}

	public SysUser queryById(Integer id) {
		Assert.notNull(id, Resources.getMessage("USER_ID_IS_NULL"));
		SysUser sysUser = provider.queryById(id);
		if (sysUser != null) {
			sysUser.setPassword(null);
		}
		return sysUser;
	}

	public void updatePassword(Integer id, String password) {
		Assert.notNull(id, Resources.getMessage("USER_ID_IS_NULL"));
		Assert.notNull(password, Resources.getMessage("PASSWORD_IS_NULL"));
		SysUser sysUser = provider.queryById(id);
		Assert.notNull(sysUser, String.format(Resources.getMessage("USER_IS_NULL"), id));
		sysUser.setPassword(SecurityUtil.encryptSHA(password));
		provider.update(sysUser);
	}

	public String encryptPassword(String password) {
		return provider.encryptPassword(password);
	}

	public void thirdPartyLogin(ThirdPartyUser thirdUser) {
		// 查询是否已经绑定过
		String userId = provider.queryUserIdByThirdParty(thirdUser.getOpenid(), thirdUser.getProvider());
		if (StringUtils.isBlank(userId)) {
			SysUser sysUser = insertThirdPartyUser(thirdUser);
			LoginHelper.login(sysUser.getAccount(), sysUser.getPassword());
		}
	}

	public SysUser insertThirdPartyUser(ThirdPartyUser thirdUser) {
		return provider.insertThirdPartyUser(thirdUser);
	}
}
