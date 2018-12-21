package com.leo.spring.delegate;

public class DispatcherTest {

	
	public static void main(String[] args) {
		//客户端需要配置具体的干活的人，实际使用中需要动态配置
		//例如使用工厂模式生产
		//实际使用时，根据类型匹配
		Dispatcher dispatcher = new Dispatcher(new ExectorA());
		//看上去好像是我们的项目经理在干活
		//但实际干活的人是普通员工
		//这就是典型，干活是我的，功劳是你的
		dispatcher.doing();
	}
	
}