package com.test.service.impl;

import java.util.List;

import com.test.entity.Message;

public interface IMessageService{
	
	List<Message> queryAll();
	
	List<Message> querySonByParentId(int parentId);

}
