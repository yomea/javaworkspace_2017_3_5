package com.jibx;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IUnmarshallingContext;
/**
 * 执行ant的build.xml才不会报错
 * @author may
 *
 */

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			IBindingFactory bfact = BindingDirectory.getFactory(Customer.class);
			// unmarshal customer information from file
			IUnmarshallingContext uctx = bfact.createUnmarshallingContext();
			File dataFile = new File("data.xml");
			System.out.println("filepath:" + dataFile.getAbsolutePath());
			InputStream in = new FileInputStream(dataFile);
			Customer customer = (Customer) uctx.unmarshalDocument(in, null);
			System.out.println("customer.firstName:" + customer.getFirstName());
			System.out.println("customer.lastName:" + customer.getLastName());
			System.out.println("customer.age:" + customer.getAge());
			System.out.println("customer.phone:" + customer.getPhone());
			System.out.println("customer.address.addressName:" + customer.getAddress().getAddressName());
			System.out.println("customer.address.city:" + customer.getAddress().getCity());
			System.out.println("customer.address.nation:" + customer.getAddress().getNation());
			System.out.println("((Company)customer.companyList.get(0)).comName:"
					+ ((Company) customer.getCompanyList().get(0)).getComName());
			System.out.println("((Company)customer.companyList.get(0)).address:"
					+ ((Company) customer.getCompanyList().get(0)).getAddress());
			System.out.println("((Company)customer.companyList.get(1)).comName:"
					+ ((Company) customer.getCompanyList().get(1)).getComName());
			System.out.println("((Company)customer.companyList.get(1)).address:"
					+ ((Company) customer.getCompanyList().get(1)).getAddress());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
