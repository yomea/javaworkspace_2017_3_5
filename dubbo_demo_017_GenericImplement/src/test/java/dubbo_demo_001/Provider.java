package dubbo_demo_001;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.rpc.RpcContext;

public class Provider {
	
	
	public static void main(String[] args) throws Exception {
		 @SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:provider.xml"});
	        context.start();
//	        String str = RpcContext.getContext().getAttachment("index"); // 获取客户端隐式传入的参数，用于框架集成，不建议常规业务使用
//	      System.out.println(str);
	        System.in.read(); // 按任意键退出
	}

}
