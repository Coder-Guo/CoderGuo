package com.activiti.definition;

import java.io.InputStream;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.repository.Deployment;
import org.junit.jupiter.api.Test;

public class ProcessDefinitionTest {

	/**
	 * @Title: getDefaultProcessEngine
	 * @Description: TODO(使用默认方法获取activiti流程引擎)
	 * @author CoderGuo
	 * @date 2020-01-15 04:41:52
	 */
	static ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();

	/**
	 * @Title: deployeeProcess
	 * @Description: TODO(部署流程)
	 * @author CoderGuo
	 * @date 2020-01-16 10:42:01
	 */
	@Test
	public void deployeeProcess() {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("processes/processes.zip");
		ZipInputStream zipInputStream = new ZipInputStream(inputStream);
		Deployment deployment = processEngine.getRepositoryService()// 获取与流程定义、部署相关的对象
			.createDeployment()// 创建部署对象
			.name("leave")// 添加要部署的流程名称。该名称是要部署的流程BPMN的ID
			//.addClasspathResource("processes/leave.bpmn")// 添加流程文件，从classpath路径下查找，一次只能加载一个
			//.addClasspathResource("processes/leave.png")// 添加流程文件，从classpath路径下查找，一次只能加载一个
			.addZipInputStream(zipInputStream)
			.deploy();// 部署
		System.out.println("流程ID：" + deployment.getId());
		System.out.println("流程名称：" + deployment.getName());
	}
	
}