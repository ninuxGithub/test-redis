package com.example;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import com.vic.Application;
import com.vic.entity.User;
import com.vic.service.IRedisService;
import com.vic.service.util.JSONUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
@SuppressWarnings("rawtypes")
public class TestRedisApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private IRedisService redisService;

	@Test
	public void test() throws Exception {
		stringRedisTemplate.opsForValue().set("aaa", "111");
		String value = stringRedisTemplate.opsForValue().get("aaa");
		System.out.println(value);
		Assert.assertEquals("111", value);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testObj() throws Exception {
		User user = new User("aa", "aa123456", "123");
		ValueOperations<String, User> operations = redisTemplate.opsForValue();
		operations.set("com.neox", user);
		operations.set("com.neo.f", user, 100, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		redisService.set("com.neo.g", JSONUtil.toJson(user));
		
		// redisTemplate.delete("com.neo.f");
		boolean exists = redisTemplate.hasKey("com.neo.f");
		if (exists) {
			System.out.println("exists is true");
		} else {
			System.out.println("exists is false");
		}
		// Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
	}
}
