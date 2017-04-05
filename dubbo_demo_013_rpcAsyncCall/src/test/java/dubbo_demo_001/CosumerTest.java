package dubbo_demo_001;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.rpc.RpcContext;
import com.dubbo.action.UserAction;

/**
 * 
 * @author Administrator
 *
 */
public class CosumerTest {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext(
				new String[] { "classpath:consumer.xml" });
		final UserAction action = application.getBean("userAction", UserAction.class);
		
		RpcContext.getContext().asyncCall(new Runnable() {
			
			@Override
			public void run() {
				action.sayHello();//合并后输出 hello world!!! UserServiceImpl_2......
				
			}
		});
		
		
	}

}
