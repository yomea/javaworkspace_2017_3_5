package dubbo_demo_001;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.dubbo.service.UserService;
import com.dubbo.service.impl.UserServiceImpl;

public class ProviderTest2 {
	
	
	public static void main(String[] args) throws Exception {
		
		//服务实现
		UserService userService = new UserServiceImpl();
		 
		// 当前应用配置
		ApplicationConfig application = new ApplicationConfig();
		application.setName("provider_api_test");
		 
		// 连接注册中心配置,这里的注册中心选用zookeeper的地址
		RegistryConfig registry = new RegistryConfig();
		registry.setAddress("zookeeper://127.0.0.1:2181");
		//registry.setUsername("aaa");
		//registry.setPassword("bbb");
		 
		// 服务提供者协议配置(以什么样子的协议来与客户端进行通信，客户端被迫必须接受这中协议方式)
		ProtocolConfig protocol = new ProtocolConfig();
		protocol.setName("dubbo");//使用dubbo协议
		protocol.setPort(8080);
		protocol.setThreads(200);
		 
		// 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口
		 
		// 服务提供者暴露服务配置
		ServiceConfig<UserService> service = new ServiceConfig<UserService>(); // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
		service.setApplication(application);
		service.setRegistry(registry); // 多个注册中心可以用setRegistries()
		service.setProtocol(protocol); // 多个协议可以用setProtocols()
		service.setInterface(UserService.class);//告知服务提供的借口
		service.setRef(userService);//设置实现类
		service.setVersion("1.0.0");
		 
		// 暴露及注册服务
		service.export();
		
		System.in.read();
		
		
	}

}
