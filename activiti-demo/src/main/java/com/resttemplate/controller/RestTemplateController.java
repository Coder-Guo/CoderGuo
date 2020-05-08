package com.resttemplate.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.resttemplate.entities.Product;

/**
 * 
 * @ClassName: RestTemplateController
 * @Description: TODO(描述)
 * @author CoderGuo
 * @date 2020-03-31 03:17:46
 */
@RestController
@RequestMapping("/product")
public class RestTemplateController {

	@GetMapping("/getProduct1")
	public Product getProduct1() {
		return new Product(1,"ProductA",BigDecimal.valueOf(6666.0));
	}
	
	@GetMapping(value = "/getProduct2")
	public Product getProduct2(Integer id) {
		return new Product(2,"电视",BigDecimal.valueOf(6666.0));
	}

	@GetMapping(value = "/getProduct3")
	public String getProduct3(Product product) {
		return product.toString();
	}
	
	@PostMapping(value = "/postProduct1")
	public String postProduct1(Product product) {
		return product.toString();
	}
	
	@PostMapping(value = "/postProduct2")
	public String postProduct2(@RequestBody Product product) {
		return product.toString();
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		String result = String.format("编号为%s的产品删除成功", id);
		System.out.println(result);
		return result;
	}
	
	@PutMapping(value = "/update")
	public String updateByPut(Product product) {
		String result = product.toString() + "更新成功";
		System.out.println(result);
		return result;
	}
	
	@PostMapping(value = "/upload")
	public String upload(MultipartRequest request) {
		MultipartFile file = request.getFile("file");
		String originaFileName = file.getOriginalFilename();
		return "upload success filename:" + originaFileName; 
				
	}
	
}