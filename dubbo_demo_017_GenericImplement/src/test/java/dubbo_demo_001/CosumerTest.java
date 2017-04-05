package dubbo_demo_001;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.GenericService;

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
		final GenericService service = (GenericService) application.getBean("service");

		String str = (String) service.$invoke("sayHello", new String[] {}, new Object[] {});
		System.out.println(str);// 这里输出返回的值
		
		String ip = RpcContext.getContext().getRemoteHost();
		
		List<URL> urls = RpcContext.getContext().getUrls();
		
		for (URL url : urls) {
			System.out.println(url);
		}
		
		System.out.println(ip);//192.168.243.1
		
		//setAttachment设置的KV，在完成下面一次远程调用会被清空。即多次远程调用要多次设置。
		RpcContext.getContext().setAttachment("index", "1"); // 隐式传参，后面的远程调用都会隐式将这些参数发送到服务器端，类似cookie，用于框架集成，不建议常规业务使用
		
		/**
		 * RpcContext是一个ThreadLocal的临时状态记录器，当接收到RPC请求，或发起RPC请求时，RpcContext的状态都会变化。
		 * 比如：A调B，B再调C，则B机器上，在B调C之前，RpcContext记录的是A调B的信息，在B调C之后，RpcContext记录的是B调C的信息。
		 */
		RpcContext.getContext().asyncCall(new Runnable() {

			@Override
			public void run() {
				/**
				 * 第一个参数指的是方法名，第二个参数指的是参数的类型，第三个参数指的是参数
				 */
				
				String str = (String) service.$invoke("sayHello", new String[] {}, new Object[] {});
				System.out.println(str);// 这里输出null
			}
		});

	}

}
