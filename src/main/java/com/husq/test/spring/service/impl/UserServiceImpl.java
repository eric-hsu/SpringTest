package com.husq.test.spring.service.impl;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.husq.test.spring.service.UserService;
import com.husq.test.spring.vo.User;

@Service("userService")
@Scope("prototype")
public class UserServiceImpl implements UserService {
	private Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	public boolean login(User user) {
		logger.info("enter service method save");
		return false;
	}

}
