package dubbo_demo_001;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.rpc.RpcException;
import com.dubbo.service.ValidationParameter;
import com.dubbo.service.ValidationService;

/**
 * JSR303 校验框架使用方式
 * Order order = new Order(); … ValidatorFactory factory =
 * Validation.buildDefaultValidatorFactory(); Validator validator =
 * factory.getValidator(); Set<ConstraintViolation<Order>> violations =
 * validator.validate(order);
 * 
 * @author may
 *
 */
public class ValidationConsumer {

	public static void main(String[] args) throws Exception {
		String config = ValidationConsumer.class.getPackage().getName().replace('.', '/') + "/validation-consumer.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
		context.start();

		ValidationService validationService = (ValidationService) context.getBean("validationService");

		/*boolean flag = validationService.getClass().getMethod("save", ValidationParameter.class).isAnnotationPresent(Save.class);
		
		System.out.println(flag);*/
		
		// Save OK
		ValidationParameter parameter = new ValidationParameter();
		parameter.setName("liangfei");
		parameter.setEmail("liangfei@liang.fei");
		parameter.setAge(50);
		parameter.setLoginDate(new Date(System.currentTimeMillis() - 1000000));
		parameter.setExpiryDate(new Date(System.currentTimeMillis() + 1000000));
		validationService.save(parameter);
		System.out.println("Validation Save OK");

		// Save Error
		try {
			parameter = new ValidationParameter();
			validationService.save(parameter);
			System.err.println("Validation Save ERROR");
		} catch (RpcException e) {
			ConstraintViolationException ve = (ConstraintViolationException) e.getCause();
			Set<ConstraintViolation<?>> violations = ve.getConstraintViolations();
			System.out.println(violations);
		}

		// Delete OK
		validationService.delete(2, "abc");
		System.out.println("Validation Delete OK");

		// Delete Error
		try {
			validationService.delete(0, "abc");
			System.err.println("Validation Delete ERROR");
		} catch (RpcException e) {
			ConstraintViolationException ve = (ConstraintViolationException) e.getCause();
			Set<ConstraintViolation<?>> violations = ve.getConstraintViolations();
			System.out.println(violations);
		}
	}

}
