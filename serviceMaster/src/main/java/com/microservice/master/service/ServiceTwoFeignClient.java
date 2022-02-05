/**
 * 
 */
package com.microservice.master.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservice.master.data.ServiceData;

/**
 * @author harshadnelwadkar
 *
 */
@FeignClient(value="SERVICE-TWO")
@LoadBalancerClient(name = "SERVICE-TWO")
public interface ServiceTwoFeignClient {

	@GetMapping(path = "/two/hello")
	public String sayHello();

	@GetMapping(path = "/two/service-info")
	public String getServerOneInfo(HttpServletRequest request);

	@GetMapping(path = "/two/get-data")
	public ServiceData getDataOne();

	@PostMapping(path = "/two/post-data")
	public ServiceData postDataOne(@RequestBody ServiceData data);

	@GetMapping(path = "/two/welcome-message")
	public String welcomeMessage();

	@GetMapping(path = "/two/hello-service")
	public String helloService();

	@GetMapping(path = "/two/service-two-code")
	public String serviceTwoCode();
	
	@GetMapping(path = "/two/get-data-zero")
	public ServiceData getDataZero(HttpServletRequest request);
}
