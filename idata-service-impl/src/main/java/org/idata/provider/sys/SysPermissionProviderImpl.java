//package org.idata.provider.sys;
//
//import java.util.Map;
//
//import org.idata.core.support.dubbo.BaseProviderImpl;
//import org.idata.core.support.dubbo.spring.annotation.DubboService;
//import org.idata.mybatis.generator.dao.SysPermissionMapper;
//import org.idata.mybatis.generator.model.SysPermission;
//import org.idata.mybatis.sys.dao.SysPermissionExpandMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.Cacheable;
//
//import com.github.pagehelper.PageInfo;
//
///**
// * URL权限管理
// * 
// * @author ShenHuaJie
// * @version 2016年5月20日 下午3:19:49
// */
//@DubboService(interfaceClass = SysPermissionProvider.class)
//@CacheConfig(cacheNames = "sysPermission")
//public class SysPermissionProviderImpl extends BaseProviderImpl<SysPermission> implements SysPermissionProvider {
//	@Autowired
//	private SysPermissionMapper sysPermissionMapper;
//	@Autowired
//	private SysPermissionExpandMapper sysPermissionExpandMapper;
//
//	@Cacheable
//	public boolean doCheckPermissionByUserId(Integer userId, String url) {
//		return sysPermissionExpandMapper.getPermissionByUserId(userId, url) > 0;
//	}
//
//	@Cacheable
//	public SysPermission queryById(Integer id) {
//		return sysPermissionMapper.selectByPrimaryKey(id);
//	}
//
//	public SysPermission update(SysPermission record) {
//		if (record.getId() == null) {
//			sysPermissionMapper.insert(record);
//		} else {
//			sysPermissionMapper.updateByPrimaryKey(record);
//		}
//		return record;
//	}
//
//	public void delete(Integer id) {
//		sysPermissionMapper.deleteByPrimaryKey(id);
//	}
//
//	public PageInfo<SysPermission> query(Map<String, Object> params) {
//		return null;
//	}
//}
