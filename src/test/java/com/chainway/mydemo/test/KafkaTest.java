package com.chainway.mydemo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ljc.mydemo.kafka.KafkaProducerServer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class KafkaTest {

	@Autowired
	KafkaProducerServer server;

	@Test
	public void test01() throws InterruptedException {
		server.testKafkaSend();
	}
}