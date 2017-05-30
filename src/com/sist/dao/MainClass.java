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
			methods[0].invoke(obj, "홍길동"); //어느 메소드가 0번이 될지 모른다. 메소드 구분하기 위해 annotation을 사용한다.
			//reflection사용하면 private변수까지 제어할수 있기때문에 객체지향이 깨진다는 논란은 있다.
			
			/*
			 * 	리플렉션 => 클래스 정보를 읽어서 제어
			 * 	메소드, 생성자, 멤버변수, 생성자의 매개변수 제어 가능
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
