package com.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//import org.springframework.web.portlet.ModelAndView;
//import org.springframework.web.portlet.handler.HandlerInterceptorAdapter;

public class ExecutionTimeInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		System.out.println("------------|preHandle|-----------");
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		long startTime = (Long) request.getAttribute("startTime");
		request.removeAttribute("startTime");

		long endTime = System.currentTimeMillis();
		//modelAndView.addObject("totalTime", endTime - startTime);
		System.out.println("Execution Time == " + (endTime - startTime));
		System.out.println("------------|postHandle|-----------");
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exceptionIfAny) throws Exception {
		System.out.println("------------|afterCompletion|-----------");
		// System.out.println("------------|View Rendered|-----------");
	}

}
