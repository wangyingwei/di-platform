package com.sunreal.di.mq;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rabbitmq.client.QueueingConsumer;
import com.sunreal.di.mq.consumer.MessageConsumer;


/**
 * 功能概要：
 * 
 * @author wyw
 * @since
 */
public class MessageReceiveTest {

	private Logger logger = LoggerFactory.getLogger(MessageReceiveTest.class);

	private ApplicationContext context = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("application.xml");
	}

	@Test
	public void should_receive_a_amq_message() throws Exception {
		System.out.println("==== 消息消费者项目启动 ====");
		MessageConsumer messageConsumer = (MessageConsumer) context.getBean("messageConsumer");
		while (true) {  
			Message message = messageConsumer.messageRev;
            if(message!=null){ 
            	System.out.println(" [x] Received '" + message + "'");  
            }
        }  
	}
}
