package com.sunreal.di.mq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * 功能概要：消费接收
 * 
 * @author wyw
 * @since 
 */
public class MessageConsumer implements MessageListener {
	
	private Logger logger = LoggerFactory.getLogger(MessageConsumer.class);
	
	public Message messageRev;

	@Override
	public void onMessage(Message message) {
		messageRev=message;
		logger.info("receive message:{}",message);
	}
	
	public void handleMsg(){
		System.out.println("====处理消息开始====");
		int hashCode=messageRev.getMessageProperties().hashCode();
		System.out.println("====hashCode===="+hashCode);
		System.out.println("====处理消息结束====");
	}

}
