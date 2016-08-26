package com.test.dao;

import java.util.List;

import com.test.entity.Message;

public interface IMessageDao{
	
	List<Message> queryAll();
	
	List<Message> querySonByParentId(int parentId);

}
