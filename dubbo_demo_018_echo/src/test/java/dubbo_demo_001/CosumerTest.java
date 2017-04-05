package dubbo_demo_001;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.EchoService;
import com.dubbo.service.UserService;

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
		final EchoService service = (EchoService) application.getBean("service");
		
		String str = (String) service.$echo("ok");//回声，当能够返回ok这个回声，表示服务通畅
		System.out.println(str + ".....");
		
		
	}

}
