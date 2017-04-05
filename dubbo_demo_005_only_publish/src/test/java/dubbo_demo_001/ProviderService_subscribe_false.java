package dubbo_demo_001;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProviderService_subscribe_false {
	
	
	public static void main(String[] args) throws Exception {
		 @SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:providerService_subscribe_false.xml"});
	        context.start();
	 
	        System.in.read(); // 按任意键退出
	}

}
