package dubbo_demo_001;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ValidationProvider {
    
    public static void main(String[] args) throws Exception {
        String config = ValidationProvider.class.getPackage().getName().replace('.', '/') + "/validation-provider.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
        System.in.read();
    }

}
