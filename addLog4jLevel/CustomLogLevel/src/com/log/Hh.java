package com.log;

public class Hh extends H {
	
	public static void print() {System.out.println("我是子类的print方法");}
	
	
	public static void main(String[] args) {
		
		H h = new Hh();
		h.print();//静态方法没有动态banding，要不然怎么叫静态方法
		
		/*H.print();
		Hh.print();*/
	}

}




