package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.common.BaseController;
import com.test.util.IPUtil;

@Controller
public class IpController extends BaseController{
	
	@RequestMapping("/error/overLimitIP")
	public ModelAndView overLimitIP(){
		String ip = IPUtil.getIp(getRequest());
		return new ModelAndView("/ipError").addObject("ip", ip);
	}
}
