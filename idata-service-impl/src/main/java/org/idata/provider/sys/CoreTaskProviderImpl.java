package org.idata.provider.sys;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.idata.core.config.Resources;
import org.idata.core.support.dubbo.spring.annotation.DubboService;
import org.idata.scheduler.provider.sys.CoreTaskProvider;

/**
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:19:19
 */
@DubboService
public class CoreTaskProviderImpl implements CoreTaskProvider {
	private final Logger logger = LogManager.getLogger();

	/** 定时清除国际化信息 */
	public void flushMessage() {
		Resources.flushMessage();
		logger.info("Messages flushed!");
	}
}
