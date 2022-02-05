/**
 * 
 */
package com.microservice.zero.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author harshadnelwadkar
 *
 */
@Component
public class InterceptorAppConfig extends WebMvcConfigurerAdapter {

	@Autowired
	RequestInterceptor requestInteceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestInteceptor);
	}
}
