package dubbo_demo_001;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.callback.service.CallbackListener;
import com.callback.service.CallbackService;

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
		final CallbackService service = (CallbackService) application.getBean("service");

		service.addListener("com.callback", new CallbackListener() {

			private static final long serialVersionUID = 5987329046482568108L;

			// 参数回调方式与调用本地callback或listener相同，只需要在Spring的配置文件中声明哪个参数是callback类型即可，Dubbo将基于长连接生成反向代理，这样就可以从服务器端调用客户端逻辑。
			public void changed(String msg) {
				System.out.println("callback1:" + msg);// 这个参数被设置为callback，当启动时，会在客户端打印这条消息。
			}

			@Override
			public void test() {
				System.out.println("这是一首简单的小情歌");
				
			}
		});

	}

}
