//package org.idata.provider.sys;
//
//import java.util.Map;
//
//import org.idata.core.support.dubbo.BaseProviderImpl;
//import org.idata.core.support.dubbo.spring.annotation.DubboService;
//import org.idata.mybatis.generator.dao.SysSessionMapper;
//import org.idata.mybatis.generator.model.SysSession;
//import org.idata.mybatis.sys.dao.SysSessionExpandMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.CachePut;
//import org.springframework.cache.annotation.Cacheable;
//
//import com.github.pagehelper.PageInfo;
//
///**
// * @author ShenHuaJie
// * @version 2016年5月20日 下午3:19:19
// */
//@CacheConfig(cacheNames = "sysSession")
//@DubboService(interfaceClass = SysSessionProvider.class)
//public class SysSessionProviderImpl extends BaseProviderImpl<SysSession> implements SysSessionProvider {
//	@Autowired
//	private SysSessionMapper sessionMapper;
//	@Autowired
//	private SysSessionExpandMapper sessionExpandMapper;
//
//	@CachePut
//	public SysSession update(SysSession record) {
//		if (record.getId() == null) {
//			Integer id = sessionExpandMapper.queryBySessionId(record.getSessionId());
//			if (id != null) {
//				record.setId(id);
//				sessionMapper.updateByPrimaryKey(record);
//			} else {
//				sessionMapper.insert(record);
//			}
//		} else {
//			sessionMapper.updateByPrimaryKey(record);
//		}
//		return record;
//	}
//
//	@CacheEvict
//	public void delete(Integer id) {
//		sessionMapper.deleteByPrimaryKey(id);
//	}
//
//	// 系统触发,由系统自动管理缓存
//	public void deleteBySessionId(final String sessionId) {
//		sessionExpandMapper.deleteBySessionId(sessionId);
//	}
//
//	@Cacheable
//	public SysSession queryById(Integer id) {
//		return sessionMapper.selectByPrimaryKey(id);
//	}
//
//	public PageInfo<SysSession> query(Map<String, Object> params) {
//		this.startPage(params);
//		return getPage(sessionExpandMapper.query(params));
//	}
//}
