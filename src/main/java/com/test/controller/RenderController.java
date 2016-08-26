package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.entity.Message;
import com.test.service.impl.IMessageService;

@Controller
@RequestMapping("/render")
public class RenderController {
	
	@Autowired
	private IMessageService messageService;

	@RequestMapping("/index")
	public ModelAndView overLimitIP(Integer count) {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/message")
	public ModelAndView message() {
		List<Message> messages = messageService.queryAll();
		return new ModelAndView("message").addObject("messages", messages);
	}
	
	@RequestMapping("/reply/{parentId}")
	@ResponseBody
	public Object reply(@PathVariable("parentId") int parentId ) {
		List<Message> messages = messageService.querySonByParentId(parentId);
		return messages;
	}
}
