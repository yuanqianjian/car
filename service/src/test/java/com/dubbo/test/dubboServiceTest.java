package com.dubbo.test;

import com.alibaba.dubbo.container.Main;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class dubboServiceTest {

	public static void main(String[] args) {
		Main.main(args);
	}

	@Test
	public void testDubboService() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/spring/spring-*.xml");
		ctx.start();
		System.in.read();
		ctx.close();
	}
}
