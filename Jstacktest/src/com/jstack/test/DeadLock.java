package com.jstack.test;

/**
 * 使用jstack检查死锁问题
 * @author Administrator
 *
 */
public class DeadLock implements Runnable {
	
	private static Object o1 = new Object();
	
	private static Object o2 = new Object();
	
	private boolean flag = false;
	
	public DeadLock(boolean flag) {
		this.flag = flag;
		
	}

	@Override
	public void run() {
		
		if(flag) {
			synchronized (o1) {
				System.out.println("o1...............true");
				
				synchronized (o2) {
					System.out.println("o2...............true");
				}
			}
			
		} else {
			synchronized (o2) {
				System.out.println("o2...............false");
				
				synchronized (o1) {
					System.out.println("o1...............false");
				}
			}
			
			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		//D:\javaworkspace_2017_3_5\Jstacktest
		//System.out.println(System.getProperty("user.dir"));
		
		new Thread(new DeadLock(true)).start();
		new Thread(new DeadLock(false)).start();
		
	}

}
