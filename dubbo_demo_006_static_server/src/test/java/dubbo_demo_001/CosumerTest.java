package dubbo_demo_001;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dubbo.action.UserAction;

/**
 * 文档中还提到了独立的第三方提供者，这个提供者未在本注册服务上注册，就用户主动调用一下代码将它注册到注册中心。
 * RegistryFactory registryFactory = ExtensionLoader.getExtensionLoader(RegistryFactory.class).getAdaptiveExtension();
 * Registry registry = registryFactory.getRegistry(URL.valueOf("zookeeper://10.20.153.10:2181"));
 * registry.register(URL.valueOf("memcached://10.20.153.11/com.foo.BarService?category=providers&dynamic=false&application=foo"));
 * @author Administrator
 *
 */
public class CosumerTest {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext(
				new String[] { "classpath:consumer.xml" });
		UserAction action = application.getBean("userAction", UserAction.class);
		action.sayHello();
	}

}
