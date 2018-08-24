package com.koal.learning.springboot.chapterzs.config;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.extern.log4j.Log4j;

/**
 * 
 * @author zhangS
 *
 * @date 2018年8月17日
 *   在不同的环境下进行动态激活bean
 */
@Log4j
@Profile(value="dev")
@Configuration
public class ProfileBeam {

	@PostConstruct
	public void init() {
		log.error("dev配置激活了！！");
	}
}
