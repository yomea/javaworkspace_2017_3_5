package dubbo_demo_001;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.rpc.RpcContext;
import com.dubbo.service.UserService;

/**
 * 
 * @author Administrator
 *
 */
public class CosumerTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext(
				new String[] { "classpath:consumer.xml" });
		final UserService service = (UserService) application.getBean("service");
		
		
		String str = service.sayHello("hello world");
		//当配置为异步时，返回的值是null
		System.out.println(str);
		//如果配置为return="false"，那么这里的的future是空值
		 Future<String> future = RpcContext.getContext().getFuture();
		 
		 String s = future.get();
		
		 System.out.println(s);
		
		
	}

}
