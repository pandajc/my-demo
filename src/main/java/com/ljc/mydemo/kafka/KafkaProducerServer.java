package com.ljc.mydemo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class KafkaProducerServer {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void testKafkaSend() throws InterruptedException {
		
		String[] topicArr = {"odd", "even"};
		int i = 1;
		while (true) {
			String topic = i % 2 == 0 ? topicArr[1] : topicArr[0];
			String data = "kafka生产者的第 " + i + " 条数据,主题: " + topic;
			kafkaTemplate.send(topic, i + "", data);
			System.err.println("===========" + data);
			i++;
			
			Thread.sleep(500);
			if (i % 20 == 0) {
				Thread.sleep(3000);
			}
		}
		
		
	}
	
}
