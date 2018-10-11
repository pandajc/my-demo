package com.ljc.mydemo.kafka.api;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class ConsumerAPI {

	public static void main(String[] args) {
		Properties props = new Properties();

		props.put("bootstrap.servers", "192.168.22.100:9092");
		System.out.println("this is the group part test 1");
		// 消费者的组id
		props.put("group.id", "0");// 这里是GroupA或者GroupB

		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");

		// 从poll(拉)的回话处理时长
		props.put("session.timeout.ms", "30000");
		// poll的数量限制
		// props.put("max.poll.records", "100");

		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
		
		// 订阅主题列表topic
//		consumer.subscribe(Arrays.asList("foo", "alarm-842636425"));
		int i = 0;
		long last = 0;
		long temp = 0;
		while (true) {
			System.err.println("-----"+consumer.listTopics());
			if (temp == 0) {
				temp = System.currentTimeMillis();
			}
			
			ConsumerRecords<String, String> records = consumer.poll(100);
			for (ConsumerRecord<String, String> record : records) {
				// 正常这里应该使用线程池处理，不应该在这里处理
				System.err.println("~~~~~~~~~~" + record);
			}
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
			}
			System.err.println(i++);
			long curr = System.currentTimeMillis();
			last = curr - temp;
			if (last >= 10000) {
				System.err.println("!!!!!!!!!!!!!!!!!!!!! 过去了10秒");
				last = 0;
				temp = 0;
			}
			/*try {
				Thread.sleep(10*60*1000);
			} catch (InterruptedException e) {
			}*/
		}
	}

}
