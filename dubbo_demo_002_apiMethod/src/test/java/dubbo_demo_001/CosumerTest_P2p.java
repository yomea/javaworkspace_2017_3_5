package dubbo_demo_001;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.dubbo.service.UserService;

public class CosumerTest_P2p {

	public static void main(String[] args) {

		// 当前应用配置
		ApplicationConfig application = new ApplicationConfig();
		application.setName("yyy");

		// 连接注册中心配置，
		RegistryConfig registry = new RegistryConfig();
		registry.setAddress("zookeeper://127.0.0.1:2181");
		// registry.setUsername("aaa");
		// registry.setPassword("bbb");

		// 方法级配置
		/*
		 * List<MethodConfig> methods = new ArrayList<MethodConfig>();
		 * MethodConfig method = new MethodConfig(); method.setName("sayHello");
		 * method.setTimeout(10000);//链接等待 method.setRetries(0);//重试次数
		 * methods.add(method);
		 */

		// 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接

		// 引用远程服务
		ReferenceConfig<UserService> reference = new ReferenceConfig<UserService>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
		reference.setApplication(application);
		reference.setInterface(UserService.class);
		reference.setCheck(false);// 启动时不检查服务提供者是否可用，如果设置为true在服务不可用的时候就会抛出异常，设置为false，在启动时不检查，即使此时服务不可用也不会抛出异常，在服务可用时会自动连接上，如果用户开始使用了，服务依然不可用，那么就会抛出异常。
		reference.setVersion("1.0.0");
		// 如果点对点直连，可以用reference.setUrl()指定目标地址，设置url后将绕过注册中心，
		// 其中，协议对应provider.setProtocol()的值，端口对应provider.setPort()的值，
		// 路径对应service.setPath()的值，如果未设置path，缺省path为接口名com.dubbo.service.UserService
		reference.setUrl("dubbo://127.0.0.1:8081/userService");
		UserService service = reference.get();
		service.sayHello();
	}

}
