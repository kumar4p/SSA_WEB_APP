package com.ats.swaggerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ats.rest"))
				.paths(PathSelectors.regex("/ssa.*")).build();
	}//productApi()
	public ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo("SpringBoot Rest APi",
				"Spirng Boot Rest Api for Online Store",
				"2.0",
				"Terms of service",
				new springfox.documentation.service.Contact("Kumar k", "http://www.flipkart.com", "kumar4p@gmail.com"),
				"Flipkart License Version 2.0",
				"https://www.flikart.com/LICENSE-2.0");
		return apiInfo;
	}
	
}
