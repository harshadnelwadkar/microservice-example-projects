/**
 * 
 */
package com.microservice.two.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author harshadnelwadkar
 *
 */
@Component
public class RequestInterceptor implements HandlerInterceptor {

	private static Logger log = LogManager.getLogger(RequestInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("in pre handle of request inteceptor");

		log.debug("Pre handle :" + request.getRequestURI());
		log.debug("User:"+request.getRemoteUser()+" "+request.getRemoteHost()+" "+request.getRemoteAddr());

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		System.out.println("in post handle of request inteceptor");

		log.debug("Post handle :" + response.getStatus());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {
		
		System.out.println("After completion of request");
	}
}
