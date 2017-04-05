package dubbo_demo_001;

import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		
		
		/*
		 * // 基本类型以及Date,List,Map等不需要转换，直接调用 
			Object result = genericService.$invoke("sayHello", new String[] {"java.lang.String"}, new Object[] {"world"}); 
			 
			// 用Map表示POJO参数，如果返回值为POJO也将自动转成Map 
			Map<String, Object> person = new HashMap<String, Object>(); 
			person.put("name", "xxx"); 
			person.put("password", "yyy"); 
			Object result = genericService.$invoke("findPerson", new String[]{"com.xxx.Person"}, new Object[]{person}); // 如果返回POJO将自动转成Map 
		 */
		
		RpcContext.getContext().asyncCall(new Runnable() {
			
			@Override
			public void run() {
				/**
				 * 第一个参数指的是方法名，第二个参数指的是参数的类型，第三个参数指的是参数
				 */
				service.$invoke("sayHello", new String[]{}, new Object[]{});
				
			}
		});
		
		
	}

}
