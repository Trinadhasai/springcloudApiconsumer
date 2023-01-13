package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/user")
public class ConsumerController
{
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping("/getuser")
	public void getall() throws RestClientException, Exception
	{
		
		//List<ServiceInstance> instances = discoveryClient.getInstances("company-producer");
		
		List<ServiceInstance> instances = discoveryClient.getInstances("gateway-service");
		
		System.out.println(instances);
		
		ServiceInstance serviceInstance = instances.get(0);
		
		
		String baseUrl = serviceInstance.getUri().toString();
		
		RestTemplate restTemplate = new RestTemplate();
		
		baseUrl = baseUrl+"/api/v1.0/market/company/getall";
		baseUrl = baseUrl+"/api/v1.0/market/company/info/{id}";
		baseUrl = baseUrl+"/api/v1.0/market/company/register";
		baseUrl = baseUrl+"/api/v1.0/market/company/put/{id}";
		baseUrl = baseUrl+"/api/v1.0/market/company/delete/{id}";
		
		ResponseEntity<String> response = null;
		try
		{
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
			response.toString();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println(response.getBody());
		
	}
	@GetMapping("/getuser")
	public void getalls() throws RestClientException, Exception
	{
		
		List<ServiceInstance> instances = discoveryClient.getInstances("company-producer");
		System.out.println(instances);
		
		ServiceInstance serviceInstance = instances.get(0);
		
		
		String baseUrl = serviceInstance.getUri().toString();
		
		RestTemplate restTemplate = new RestTemplate();
		
		baseUrl = baseUrl+"/api/v1.0/market/company/getall";
		baseUrl = baseUrl+"/api/v1.0/market/company/info/{id}";
		baseUrl = baseUrl+"/api/v1.0/market/company/register";
		baseUrl = baseUrl+"/api/v1.0/market/company/put/{id}";
		baseUrl = baseUrl+"/api/v1.0/market/company/delete/{id}";
		
		ResponseEntity<String> response = null;
	}
	private static HttpEntity<?> getHeaders() throws Exception
	{
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}

}











