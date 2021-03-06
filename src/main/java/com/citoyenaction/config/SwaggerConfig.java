package com.citoyenaction.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.google.common.base.Predicate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig
{
	
	@Autowired
	Environment env;

	@SuppressWarnings("unchecked")
	private Predicate<String> paths()
	{
		return or(regex(".*?"));
	}
	//@// @formatter:off
 
	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors
				.basePackage("com.citoyenaction"))
				.paths(paths())
				.build().apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo()
	{
		return new ApiInfo("CitoyenAction service REST API", "Citoyen Action service.",
				env.getProperty("info.build.version"),
				"CitoyenAction service", 
				new Contact("Reda Zilat", "http://www.citoyenaction.com",
							"redaovish200@hotmail.com"), 
							"License of API", "API license URL",
							Collections.emptyList());
	}
	
	
}