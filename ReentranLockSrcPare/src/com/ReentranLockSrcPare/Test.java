package com.ReentranLockSrcPare;

import java.util.concurrent.locks.ReentrantLock;

public class Test {
	
	private static final ReentrantLock lock = new ReentrantLock();
	
	public static void main(String[] args) {
		
		new Thread() {
			
			@Override
			public void run() {
				
				test();
			}

			
		}.start();
		test();
	}
	
	/**
	 * debug查看源代码
	 */
	private static void test() {
		
		try {
			lock.lock();
			
		} catch(Exception e) {
			//TODO
			
		} finally {
			//lock.unlock();
		}
		
		
	}

}
