package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import com.example.demo.Controller.ConsumerController;

@SpringBootApplication
public class SpringcloudApiconsumerApplication {

	public static void main(String[] args) throws RestClientException, Exception
	{
		ApplicationContext ctx=
		SpringApplication.run(SpringcloudApiconsumerApplication.class, args);
		ConsumerController consumerController = ctx.getBean(ConsumerController.class);
		
		consumerController.getall();
		
		System.out.println(consumerController);
	}
	@Bean
	public ConsumerController consumerController()
	{
		return new ConsumerController();
	}
	

}
