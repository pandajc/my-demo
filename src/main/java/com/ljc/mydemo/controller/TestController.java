package com.ljc.mydemo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ljc.mydemo.kafka.KafkaProducerServer;

@Controller
public class TestController {
	
	@Autowired
	private KafkaProducerServer server;
	
	@RequestMapping("kafka")
	@ResponseBody
	public String testKafka() {
		new Thread(new Runnable() {
			
			public void run() {
				try {
					server.testKafkaSend();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		return "starting...";
	}
	
	
	@RequestMapping(value="/addPoints.json", method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Map<String,Object>addPoints(@RequestBody UploadPointsParam param,HttpServletRequest request, HttpServletResponse response){
		System.out.println(param);
		return new HashMap<>();
	}
	
}
