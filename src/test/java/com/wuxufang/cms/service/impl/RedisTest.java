package com.wuxufang.cms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wuxufang.cms.domain.Article;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class RedisTest {

	@Autowired
	private RedisTemplate redisTemplate;
	
	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		Article a = new Article();
		a.setId(1);
		redisTemplate.opsForValue().set("article:1", a);
//		List<Article> list = new ArrayList<Article>();
//		Long leftPush = redisTemplate.opsForList().leftPush("list", list);
//		redisTemplate.opsForList().range(list, 0, -1);
//		System.out.println(leftPush);
	}
 }
