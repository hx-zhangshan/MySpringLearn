package com.koal.learning.springboot.chapterzs.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
/**
 * 
 * @author zhangS
 *
 * @date 2018年8月17日
 * perfix 的值为自定义配置文件前缀 
 *  这样直接就能批量解析 属性值
 * 
 */
@Component
@ConfigurationProperties(prefix="config")
@Data
public class Config {

	private String code;
	
	private String name;
	
	private List<String> hobby;
	
	@Value(value = "${blog.address}")
	private String address;
}
