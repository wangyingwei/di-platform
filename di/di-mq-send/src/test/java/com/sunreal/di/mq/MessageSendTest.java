package com.sunreal.di.mq;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.retry.backoff.Sleeper;

import com.sunreal.di.mq.producer.MessageProducer;


/**
 * 功能概要：
 * 
 * @author wyw
 * @since
 */
public class MessageSendTest {

	private Logger logger = LoggerFactory.getLogger(MessageSendTest.class);

	private ApplicationContext context = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("application.xml");
	}

	@Test
	public void should_send_a_amq_message() throws Exception {
		System.out.println("==== 消息生产者项目启动 ====");
		MessageProducer messageProducer = (MessageProducer) context.getBean("messageProducer");
		// int a = Integer.MAX_VALUE;
		// while (a > 0) {
		for (int i = 0; i < 3; i++) {
			messageProducer.sendMessage("Hello, I am amq sender num :" + i);
			try {
				// 暂停一下，好让消息消费者去取消息打印出来
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
