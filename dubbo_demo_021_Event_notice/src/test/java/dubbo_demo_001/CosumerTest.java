package dubbo_demo_001;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.event.notice.action.UserAction;
import com.event.notice.entity.User;
import com.event.test.DemoCallback;
import com.event.test.impl.DemoCallbackImpl;

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
		final UserAction action = (UserAction) application.getBean("userAction");
		
		User user = action.getUser(1);
		
		System.out.println(user);
		
		final DemoCallbackImpl callback = (DemoCallbackImpl) application.getBean("demoCallback");
		
		for(int i = 0; i < 10; i++) {
			System.out.println(callback.onreturn);
			System.out.println("######################");
			System.out.println(callback.onthrow);
			Thread.sleep(500);
			
		}


	}

}
