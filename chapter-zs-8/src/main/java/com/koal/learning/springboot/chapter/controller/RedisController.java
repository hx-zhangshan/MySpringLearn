package com.koal.learning.springboot.chapter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = { "/redis" })
@Api(tags="redis的测试api")
public class RedisController {

	@Autowired
	StringRedisTemplate template;

	@GetMapping("set/{key}/{value}")
	@ApiOperation(value = "设置缓存的值")
	public String set(@PathVariable("key") String key, @PathVariable("value") String value) {

		// 这里的key不能为null
		// 对简单的值 进行操作
		template.opsForValue().set(key, value);
		return key + "," + value;
	}

	@GetMapping("get/{key}")
	@ApiOperation(value = "根据key获取值")
	public String get(@PathVariable("key") String key) {

		return "key=" + key + "value=" + template.opsForValue().get(key);
	}
}
