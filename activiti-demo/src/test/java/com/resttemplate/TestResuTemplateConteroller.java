package com.resttemplate;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.resttemplate.entities.Product;

public class TestResuTemplateConteroller {

	RestTemplate restTemplate = null;
	
	@Before
	public void setup() {
		restTemplate = new RestTemplate();
	}
	
	@Test
	public void testGetProduct1() {
		String url = "http://localhost:8080/product/getProduct1";
		String result = restTemplate.getForObject(url, String.class);
		System.out.println("String方法返回的结果是:" + result);
		Assert.hasText(result, "getProduct1返回的结果为空");
		
		Product product = restTemplate.getForObject(url, Product.class);
		System.out.println("Get方法返回的结果是:" + product);
		Assert.notNull(product,"Get方法返回的结果为空");
		
		ResponseEntity<Product> responseProduct = restTemplate.getForEntity(url, Product.class);
		System.out.println("Get获取的实体对象的方法返回结果是:" + responseProduct);
		Assert.isTrue(responseProduct.getStatusCode().equals(HttpStatus.OK),"Get获取实体对象的方法不成功");
	}
	
	@Test
	public void testPostProduct1() {
		
		
		
	}
	
	
}