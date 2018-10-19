package com.koal.learning.springboot.chapter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
/**
 * 通过 fileUpload的方式 进行上传文件 需要配置这个类
 * 
 * @author zhangS
 *
 * @date 2018年10月19日
 */
@Configuration
public class UploadFileConfig {

	@Bean
	public MultipartResolver resolver() {
		return new CommonsMultipartResolver();
	}
}
