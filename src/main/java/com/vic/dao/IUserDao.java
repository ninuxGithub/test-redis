package com.vic.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vic.entity.User;

/**
 * 
 * @author vic
 * @desc User Mapper Dao
 */
@Repository
public interface IUserDao {

	public List<User> getAll();
	
}
