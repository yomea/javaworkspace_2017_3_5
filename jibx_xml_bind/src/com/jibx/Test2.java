package com.jibx;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IMarshallingContext;
import org.jibx.runtime.JiBXException;

public class Test2 {

	/**
	 * 
	 * 执行ant的build.xml才不会报错
	 * 
	 * @author may
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			IBindingFactory factory = BindingDirectory.getFactory(Customer.class);
		
			IMarshallingContext context = factory.createMarshallingContext();
			
			List<Company> company = new ArrayList<>();
			
			company.add(new Company("简爱", "heheda"));
			
			company.add(new Company("精神病院", "嘻嘻"));
			
			Address address = new Address("root", "root", "lshg");
			
			Customer customer = new Customer("a","b",22,"110",address, company);
			
			context.setIndent(2);
			
			StringWriter writer = new StringWriter();
			
			context.marshalDocument(customer, "UTF-8", null, writer);
			
			System.out.println(writer);
		
		} catch (JiBXException e) {
			
			e.printStackTrace();
		}

	}

}
