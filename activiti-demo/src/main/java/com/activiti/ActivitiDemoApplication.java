package com.activiti;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @ClassName: ActivitiDemoApplication
 * @Description: TODO(描述)工作流启动类
 * @author CoderGuo
 * @date 2020-03-27 05:39:38
 */
@ImportResource(locations = {"classpath:*/activiti.cfg.xml"})// 引入工作流配置文件
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ActivitiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivitiDemoApplication.class, args);
	}

}