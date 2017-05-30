package com.sist.dao;

import java.lang.reflect.Method;

class A{
	public void display1(String name){
		System.out.println(name+" Hello! => display1");
		
	}
	public void display2(String name){
		System.out.println(name+" Hello! => display2");
		
	}
	
}

@Controller("mc")
public class MainClass {
	public static void main(String[] args) {
		try {
			Class clsName=Class.forName("com.sist.dao.A");
			Object obj=clsName.newInstance();
			Method[] methods=clsName.getDeclaredMethods();
			methods[0].invoke(obj, "ȫ�浿"); //��� �޼ҵ尡 0���� ���� �𸥴�. �޼ҵ� �����ϱ� ���� annotation�� ����Ѵ�.
			//reflection����ϸ� private�������� �����Ҽ� �ֱ⶧���� ��ü������ �����ٴ� ����� �ִ�.
			
			/*
			 * 	���÷��� => Ŭ���� ������ �о ����
			 * 	�޼ҵ�, ������, �������, �������� �Ű����� ���� ����
			 * 
			 * 		@
			 * 		public class A{
			 * 			@
			 * 			B b;
			 * 			
			 * 			@
			 * 			public A(B b){
			 * 
			 * 			}
			 * 
			 * 			@
			 * 			public void display(){
			 * 
			 * 			}
			 * 
			 *  	}
			 * */
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
