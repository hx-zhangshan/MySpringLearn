package com.koal.learning.springboot.chapter.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 定义StringRedisTemplate 制定序列化和反序列化的处理类 直接使用这个模板里面实现了 序列化接口
 * 
 * @author zhangS
 *
 * @date 2018年9月3日
 */
@Configuration
@EnableCaching
//开启速配ring支持的缓存 
public class RedisConfig {

	@Bean("template")
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
		StringRedisTemplate template = new StringRedisTemplate(factory);
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(
				Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		// 序列化 值时使用此序列化方法
		template.setValueSerializer(jackson2JsonRedisSerializer);
		template.afterPropertiesSet();

		return template;
	}
	@Bean
	public CacheManager cacheManagerre(@Qualifier("template") RedisTemplate<String, String> template) {
		RedisCacheManager rm=new RedisCacheManager(template);
		//使用前缀
        rm.setUsePrefix(true);
        //缓存分割符 默认为 ":"
//        rcm.setCachePrefix(new DefaultRedisCachePrefix(":"));
        //设置缓存过期时间
        //rcm.setDefaultExpiration(60);//秒

		return rm;
	}
}
