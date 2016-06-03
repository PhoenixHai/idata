/**
 * 
 */
package org.idata.provider.sys;

import java.util.Map;

import org.idata.core.support.dubbo.BaseProvider;
import org.idata.core.support.login.ThirdPartyUser;
import org.idata.mybatis.generator.model.SysUser;
import org.idata.mybatis.sys.model.SysUserBean;

import com.github.pagehelper.PageInfo;

/**
 * 
 * @author ShenHuaJie
 * @version 2016年5月15日 上午11:21:47
 */
public interface SysUserProvider extends BaseProvider<SysUser> {

	public PageInfo<SysUserBean> queryBeans(Map<String, Object> params);

	public String encryptPassword(String password);

	/** 查询第三方帐号用户Id */
	public String queryUserIdByThirdParty(String openId, String provider);

	/** 保存第三方帐号 */
	public SysUser insertThirdPartyUser(ThirdPartyUser thirdPartyUser);
}
