package org.idata.web.sys;

import java.util.UUID;

import org.idata.core.support.BaseController;
import org.idata.core.util.DateUtil;
import org.idata.mybatis.generator.model.SysUser;
import org.idata.service.sys.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/")
public class IdataController extends BaseController {
	@Autowired
	private SysUserService sysUserService;

	// 登录
	@RequestMapping(value = "/test")
	public String test(ModelMap modelMap, String name) {
		modelMap.put("name", "{"+name+":"+UUID.randomUUID()+"}");
		modelMap.put("time", DateUtil.getDate());
		return "login";
	}

	@RequestMapping(value = "/test1")
	@ResponseBody
	public String test1(String name) {
		SysUser user = sysUserService.queryById(1);
		return JSON.toJSONString(user);
	}
}
