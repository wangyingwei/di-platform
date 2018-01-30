package com.sunreal.di.start;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
	public static void main(String[] args) {
		// 如果 spring 配置文件的位置是默认的，则可以直接这样启动服务
		// java -jar di-service-demo.jar &
		com.alibaba.dubbo.container.Main.main(args);

//		try {
//			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
//			context.start();
//			System.out.println("服务已经启动...");
//			System.in.read();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}