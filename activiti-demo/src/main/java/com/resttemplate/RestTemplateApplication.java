package com.resttemplate;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @ClassName: RestTemplateApplication
 * @Description: TODO(SpringBoot启动入口)
 * @author CoderGuo
 * @date 2020-03-27 05:39:15
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class RestTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestTemplateApplication.class,args);
	}
	
}