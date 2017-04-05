package dubbo_demo_001;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dubbo.api.BarServiceStub;

/**
 * 
 * @author Administrator
 *
 */
public class CosumerTest implements Serializable {

	private static final long serialVersionUID = -3943404916439514617L;

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext(
				new String[] { "classpath:consumer.xml" });
		final BarServiceStub service = (BarServiceStub) application.getBean("service");
		
		String str = service.sayHello("hello baby");
		
		System.out.println(str);


	}

}
