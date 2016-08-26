package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.IMessageDao;
import com.test.entity.Message;
import com.test.service.impl.IMessageService;

@Service
public class MessageServiceImpl implements IMessageService{
	
	@Autowired
	private IMessageDao messageDao;
	
	public List<Message> queryAll(){
		return messageDao.queryAll();
	}

	@Override
	public List<Message> querySonByParentId(int parentId) {
		return messageDao.querySonByParentId(parentId);
	}

}
