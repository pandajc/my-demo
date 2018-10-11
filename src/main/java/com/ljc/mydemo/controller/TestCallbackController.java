package com.ljc.mydemo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestCallbackController {
	
	@RequestMapping("/a/alarm")
	@ResponseBody
	public String test1(HttpServletRequest request) {
		System.err.println("a 的告警数据 " + request.getParameter("data"));
		return "200";
	}
	
	@RequestMapping("/a/trace")
	@ResponseBody
	public String test2(HttpServletRequest request) {
		System.err.println("a 的轨迹数据 " + request.getParameter("data"));
		return "200";
	}
	
}
