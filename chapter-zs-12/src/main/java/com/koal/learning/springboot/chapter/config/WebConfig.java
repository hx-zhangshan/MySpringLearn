package com.koal.learning.springboot.chapter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 这里可以不用配置 因为 META-INF/resource/ 是spring四个默认加载项中的一个 这样配置可以去配置其他一些路径
 * 
 * @author zhangS
 *
 * @date 2018年10月19日
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		super.addResourceHandlers(registry);

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/")
		//开启 缓存设置 为true，不添加resourceChain pom中的web_locale不生效。。。
				.resourceChain(false);
	}

}
