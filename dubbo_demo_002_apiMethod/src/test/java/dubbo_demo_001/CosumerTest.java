package dubbo_demo_001;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.MethodConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.dubbo.service.UserService;

public class CosumerTest {

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
		/*List<MethodConfig> methods = new ArrayList<MethodConfig>();
		MethodConfig method = new MethodConfig();
		method.setName("sayHello");
		method.setTimeout(10000);//链接等待
		method.setRetries(0);//重试次数
		methods.add(method);*/

		// 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接

		// 引用远程服务
		ReferenceConfig<UserService> reference = new ReferenceConfig<UserService>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
		reference.setApplication(application);
		reference.setCheck(true);
		reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
		reference.setInterface(UserService.class);// 注册要调用的接口
		reference.setVersion("1.0.0");// 设置版本，这个版本与服务提供者的一样，这样的话可以自由选择版本实现服务类
		//reference.setMethods(methods);//注册方法
		// 和本地bean一样使用xxxService，获得接口实现服务类的一个对象
		UserService userService = reference.get(); // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
		// 调用远程接口的方法，服务接口端将在服务器上运行相应的方法
		userService.sayHello();
		//reference.getMethods().get(0).getOninvoke();调用方法
		
		
		
		//ReferenceConfig<XxxService> reference = new ReferenceConfig<XxxService>();
		
		// 如果点对点直连，可以用reference.setUrl()指定目标地址，设置url后将绕过注册中心，
		// 其中，协议对应provider.setProtocol()的值，端口对应provider.setPort()的值，
		// 路径对应service.setPath()的值，如果未设置path，缺省path为接口名com.dubbo.service.UserService
		//reference.setUrl("dubbo://127.0.0.1:8080/com.dubbo.service.UserService");
	}

}
