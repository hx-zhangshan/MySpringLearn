package com.koal.learning.springboot.chapter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * swagger2 的配置类 进行 开启 
 * 
 * 在网址 http://127.0.0.1:8888/zs/swagger-ui.html jinxing fangwen
 * @author zhangS
 *
 * @date 2018年8月30日
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

	//进行多环境的配置 在生产环境下 关闭掉swagger 
	@Value(value = "${swagger.enabled}")
	boolean enableSwagger;
	@Bean
	public Docket createRestApi() {
		
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).
				//是否开启
				enable(enableSwagger).select()
				//扫描包的路径
				.apis(RequestHandlerSelectors.basePackage("com.koal.learning.springboot.chapter"))
                // 指定路径处理PathSelectors.any()代表所有的路径
                .paths(PathSelectors.any()).build().pathMapping("/");
	}
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot-Swagger2集成和使用-demo示例")
                .description("zhangS | 糊你大熊脸")
                // 作者信息
                .contact(new Contact("zhangS", "https://blog.lqdev.cn/", "260262911@qq.com"))
                .version("1.0.0")
                .build();
    }
}
