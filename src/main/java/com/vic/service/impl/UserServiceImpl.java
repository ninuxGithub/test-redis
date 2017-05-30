package com.vic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vic.dao.IUserDao;
import com.vic.entity.User;
import com.vic.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

}
