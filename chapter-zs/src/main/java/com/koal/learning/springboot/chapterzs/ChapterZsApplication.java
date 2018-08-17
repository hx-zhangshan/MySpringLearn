package com.koal.learning.springboot.chapterzs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
/**
 * 
 * @author pc
 * 启动类
 * @PropertySource 获取自定义配置文件 因为 application中的 属性值获取 默认isso8859编码
   *   不能识别中文 可以在自定义配置文件中 制定utf——8的编码格式
 */
@SpringBootApplication
@PropertySource(value="classpath:my.properties",encoding="utf-8")
public class ChapterZsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChapterZsApplication.class, args);
	}
}
