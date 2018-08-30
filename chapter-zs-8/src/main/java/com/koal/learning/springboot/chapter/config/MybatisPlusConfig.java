package com.koal.learning.springboot.chapter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 
 * @author zhangS
 *
 * @date 2018年8月29日
 * 配置类
 */
@ImportResource(locations= {"classpath:/mybatis/spring-mybatis.xml"})
@Configuration
public class MybatisPlusConfig {
	
}
