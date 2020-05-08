package com.activiti.commons;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;

/**
 * @ClassName: DefaultProcessEngine
 * @Description: 初始化Activiti流程引擎
 * @author CoderGuo
 * @date 2020-01-15 04:50:55
 */
public class DefaultProcessEngine {

	/**
	 * @Title: getDefaultProcessEngine
	 * @Description: TODO(使用默认方法获取activiti流程引擎)
	 * @author CoderGuo
	 * @date 2020-01-15 04:50:52
	 */
	static ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();

	/**
	 * @Title: deployeeProcess
	 * @Description: TODO(部署流程)
	 * @author CoderGuo
	 * @date 2020-01-15 05:06:40
	 */
	@Test
	public void deployeeProcess() {
		Deployment deployment = processEngine.getRepositoryService()// 获取流程定义和部署象关的Service
			.createDeployment()// 创建部署对象
			.name("leave")// 添加部署名称
			.addClasspathResource("processes/leave.bpmn")// 从classPath路径中加载对象，一次只能加载一个
			.addClasspathResource("processes/leave.png")
			.deploy();// 完成部署
		System.out.println("部署Id" + deployment.getId());
		System.out.println("部署名称" + deployment.getName());
		
	}
	
	/**
	 * @Title: startProcessEngine
	 * @Description: TODO(启动流程实例)
	 * @author CoderGuo
	 * @date 2020-01-15 05:10:26
	 */
	@Test
	public void startProcessEngine() {
		ProcessInstance processInstance = processEngine.getRuntimeService()// 获取正在执行的流程实例和执行对象相关的Service
			.startProcessInstanceByKey("leave");// 使用流程定义的Key启动该流程，Key为部署的流程bpmn文件的Id。Key启动按照最新提交的流程版本
		System.out.println("流程实例Id" + processInstance.getId());// 流程实例Id
		System.out.println("流程定义Id" + processInstance.getProcessDefinitionId());// 流程定义Id
	}
	
	/**
	 * @Title: findMyProcessEngine
	 * @Description: TODO(查询个人任务)
	 * @author CoderGuo
	 * @date 2020-01-15 05:39:43
	 */
	@Test
	public void findMyProcessEngine() {
		List<Task> taskList = processEngine.getTaskService()// 获取正在执行任务的Service
			.createTaskQuery()// 创建任务查询对象
			.taskAssignee("王五")// 指定查询个人任务
			.list();// 执行个人任务，查询办理人
		if(taskList != null && taskList.size() > 0) {
			for(int i=0, index = taskList.size(); i < index; i++) {
				System.out.println("任务ID:" + taskList.get(i).getId());
				System.out.println("任务名称:" + taskList.get(i).getName());
				System.out.println("任务创建时间:" + taskList.get(i).getCreateTime());
				System.out.println("任务办理人:" + taskList.get(i).getAssignee());
				System.out.println("流程实例ID:" + taskList.get(i).getProcessInstanceId());
				System.out.println("执行对象ID:" + taskList.get(i).getExecutionId());
				completeMyProcessTask(taskList.get(i).getId());
			}
		}
	}
	
	/**
	 * @Title: completeMyProcessTask
	 * @Description: TODO(完成任务)
	 * @param taskId 任务ID
	 * @author CoderGuo
	 * @date 2020-01-15 05:44:52
	 */
	@Test
	public void completeMyProcessTask(String taskId) {
		processEngine.getTaskService().complete(taskId);// 获取正在执行任务的Service并根据任务Id完成该任务
		System.out.println("完成任务的ID是:" + taskId);
	}
	
}