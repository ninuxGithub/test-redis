package com.vic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vic.entity.User;
import com.vic.modal.ResponseModal;
import com.vic.service.IRedisService;
import com.vic.service.IUserService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

@RestController
public class ExampleController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRedisService redisService;
	
	@RequestMapping("/users")
	public ResponseModal users(){
		List<User> users = userService.getAll();
		ResponseModal modal = new ResponseModal(200,true,"",users);
		return modal;
	}
	
	@RequestMapping("/redis/set")
	public ResponseModal redisSet(@RequestParam("value")String value){
		boolean isOk = redisService.set("name", value);
		return new ResponseModal(isOk ? 200 : 500, isOk, isOk ? "success" : "error" , null);
	}
	
	@RequestMapping("/redis/get")
	public ResponseModal redisGet(){
		String name = redisService.get("name");
		return new ResponseModal(200, true,"success",name);
	}
	
	
	
	
	/***
	 * 从这个测试可以看出Jedis 的管道pipeline  要比redisTemplate速度要快许多倍
	 * @return
	 */
	@SuppressWarnings("resource")
	@RequestMapping("/redis/putdata")
	public List<String> putdata(){
		long currentTimeMillis = System.currentTimeMillis();  
	    Jedis jedis = new Jedis("localhost", 6379);
	    jedis.auth("redis");//授权
	    
	    
	    
	    Pipeline pipelined = jedis.pipelined();  
	    for (int i = 0; i < 1000; i++) {  
	        pipelined.set("bb" + i, i + "bb");  
	    }  
	    pipelined.sync();  
	    long endTimeMillis = System.currentTimeMillis(); 
	    
	    List<String> list = new ArrayList<>();
	    list.add("jedis: "+(endTimeMillis - currentTimeMillis)+" s");
	    
	    
	    
	    long currentTimeMillis2 = System.currentTimeMillis();  
	    for (int i = 0; i < 1000; i++) {  
	    	redisService.set("aa" + i, i + "aa");
	    }  
	    long endTimeMillis2 = System.currentTimeMillis(); 
	    list.add("redisTemplate: "+(endTimeMillis2 - currentTimeMillis2)+" s");
	    return list;
	    
	}
	
}
